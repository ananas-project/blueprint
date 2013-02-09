package ananas.lib.blueprint.loader.eom;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.dom.BPNode;
import ananas.lib.blueprint.core.lang.BPDocumentLoader;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;
import ananas.lib.blueprint.core.lang.BlueprintException;
import ananas.lib.blueprint.core.util.IMacroProperties;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceInfo;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceLoader;
import ananas.lib.blueprint.loader.eom.ctrl.Ctrl_eom;
import ananas.lib.blueprint.loader.eom.target.Tar_attribute;
import ananas.lib.blueprint.loader.eom.target.Tar_class;
import ananas.lib.blueprint.loader.eom.target.Tar_element;
import ananas.lib.blueprint.loader.eom.target.Tar_eom;
import ananas.lib.blueprint.loader.eom.target.Tar_namespace;

public class EomNamespaceLoader implements BPNamespaceLoader {

	@Override
	public void load(BPEnvironment envi, BPNamespaceInfo info)
			throws BlueprintException {

		String xmlfile = info.getProperty("eom.xml");
		InputStream in = info.getClass().getResourceAsStream(xmlfile);

		try {

			BPDocumentLoader docLdr = envi.getDocumentLoaderFactory()
					.newLoader();
			BPDocument doc = docLdr.loadDocument(envi, in, "");

			Ctrl_eom eom = (Ctrl_eom) doc.getRootElement();

			// System.out.println(eom);

			MyNamespaceGenerator gen = new MyNamespaceGenerator(eom);
			gen.register(envi);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (in != null)
				in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

 
	class MyNamespaceGenerator {

		private final Tar_eom mEOM;

		public MyNamespaceGenerator(Ctrl_eom eom) {
			this.mEOM = eom.getTarget_eom();
		}

		public void register(BPEnvironment envi) {
			List<Tar_namespace> list = this.mEOM.listNamespaces();
			for (Tar_namespace ns : list) {
				this.regNS(envi, ns);
			}
		}

		private void regNS(BPEnvironment envi, Tar_namespace tns) {

			String uri = tns.getProperties().get(Const.ns_uri, false, null);
			String defaultPrefix = tns.getProperties().get(
					Const.ns_default_prefix, false, null);

			BPNamespace ns = envi.getImplementation().createNamespace(envi,
					uri, defaultPrefix);

			List<Tar_class> list = tns.listMemberClasses();
			for (Tar_class cls : list) {
				BPType type = this.loadClass(ns, cls);
				boolean rlt = this.verifyClass(cls, type);
				if (rlt) {
					if (cls.isElement()) {
						ns.registerType(type);
					}
				} else {
					throw new RuntimeException("verify type '" + cls.getName()
							+ "' return failed.");
				}

			}

			if (tns.enableExport()) {
				envi.getNamespaceRegistrar().registerNamespace(ns);
			}
		}

		private boolean verifyClass(Tar_class cls, BPType type) {

			Class<?> tc = type.getControllerClass();

			// extends

			// attributes

			List<Tar_attribute> listA = cls.listAttributes();
			for (Tar_attribute attr : listA) {
				String attrName = attr.getName();
				String methodName = this
						.toNormalJavaName(Const.set_attr_method_prefix
								+ attrName);
				Method method;
				try {
					method = tc.getMethod(methodName, BPAttribute.class);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				if (method == null) {
					throw new RuntimeException("no method for attr : "
							+ attrName);
				}
			}

			// children

			List<Tar_element> listC = cls.listChildren();
			for (Tar_element ele : listC) {

				String eleName = ele.getName();
				String eleType = ele.getType();

				Class<?> methodType = null;
				String methodName = null;

				if (eleName == null) {
					// by type
					methodName = Const.add_child_method_prefix;
				} else {
					// by name
					methodName = Const.add_child_method_prefix + eleName;
				}
				methodName = this.toNormalJavaName(methodName);

				if (eleType == null) {
					methodType = BPNode.class;
				} else {
					methodType = this.classForName(cls.getOwnerNamespace(),
							eleType);
				}

				Method method;
				try {
					method = tc.getMethod(methodName, methodType);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				if (method == null) {
					throw new RuntimeException("no method for appending Child "
							+ methodName + ":" + methodType);
				}

			}

			return true;
		}

		private Class<?> classForName(Tar_namespace ns, String typeString) {
			// TODO Auto-generated method stub
			return null;
		}

		private String toNormalJavaName(String string) {
			return string;
		}

		private BPType loadClass(BPNamespace ns, Tar_class cls) {

			Tar_namespace ns2 = cls.getOwnerNamespace();
			IMacroProperties props = ns2.getProperties();
			props.put(Const.ns_local_name, cls.getName());

			String localName = cls.getName();
			MyType type = new MyType(ns, localName);
			type.mControllerClass = this.classForName(cls,
					Const.ns_default_controller_class);
			type.mTargetClass = this.classForName(cls,
					Const.ns_default_target_class);
			type.loadMethods();

			return type;

		}

		private Class<?> classForName(Tar_class cls, String key) {

			String className;
			if (Const.ns_default_controller_class.equals(key)) {
				className = cls.getControllerClassName();
			} else {
				className = cls.getTargetClassName();
			}

			IMacroProperties props = cls.getOwnerNamespace().getProperties();
			if (className == null) {
				className = props.get(key, false, null, true);
			} else {
				className = props.processMacro(className);
			}

			try {
				return Class.forName(className);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}

	static class MethodContext {

		private final Method mMethod;
		private final Class<?> mParamType;

		public MethodContext(Method mtd) {
			this.mMethod = mtd;
			this.mParamType = this._getParamType(mtd);
		}

		private Class<?> _getParamType(Method mtd) {
			return mtd.getParameterTypes()[0];
		}

		public Method getMethod() {
			return this.mMethod;
		}

		public Class<?> getParamType() {
			return this.mParamType;
		}
	}

	static class MyType implements BPType {

		private final BPNamespace mNamespace;
		private final String mLocalName;
		public Class<?> mControllerClass;
		public Class<?> mTargetClass;

		final List<MethodContext> mMethodList;
		final Map<String, MethodContext> mMethodMap;// key to context

		public MyType(BPNamespace ns, String localName) {
			this.mNamespace = ns;
			this.mLocalName = localName;

			this.mMethodList = new ArrayList<MethodContext>();
			this.mMethodMap = new HashMap<String, MethodContext>();
		}

		@Override
		public Class<?> getTargetClass() {
			return this.mTargetClass;
		}

		@Override
		public Class<?> getControllerClass() {
			return this.mControllerClass;
		}

		@Override
		public String getLocalName() {
			return this.mLocalName;
		}

		@Override
		public BPNamespace getOwnerNamespace() {
			return this.mNamespace;
		}

		@Override
		public boolean appendChildToParent(BPElement parent, BPNode child) {

			String key = this.keyForElement(child.getLocalName());
			MethodContext context = this.mMethodMap.get(key);
			Method method = null;
			if (context == null) {
				for (MethodContext cont : this.mMethodList) {
					Class<?> paramType = cont.getParamType();
					if (paramType.isInstance(child)) {
						method = cont.getMethod();
						break;
					}
				}
			} else {
				method = context.getMethod();
			}
			if (method == null) {
				return false;
			}

			try {
				boolean rlt = (Boolean) method.invoke(parent, child);
				return rlt;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return false;
		}

		private String keyForElement(String localName) {
			return ("ele:" + localName);
		}

		@Override
		public boolean setAttributeForParent(BPElement parent, BPAttribute attr) {

			String key = this.keyForAttr(attr.getLocalName());
			MethodContext context = this.mMethodMap.get(key);
			Method method = context.getMethod();
			try {
				boolean rlt = (Boolean) method.invoke(parent, attr);
				return rlt;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return false;
		}

		private String keyForAttr(String localName) {
			return ("attr:" + localName);
		}

		public void loadMethods() {

			Method[] methods = this.mControllerClass.getMethods();
			for (Method mtd : methods) {
				String name = mtd.getName();
				if (name.startsWith(Const.add_child_method_prefix)) {
					String pref = Const.add_child_method_prefix;
					String localName = name.substring(pref.length());
					this._addAppendChildMethod(mtd, localName);

				} else if (name.startsWith(Const.set_attr_method_prefix)) {
					String pref = Const.set_attr_method_prefix;
					String localName = name.substring(pref.length());
					this._addSetAttrMethod(mtd, localName);
				}

			}

		}

		private void _addSetAttrMethod(Method mtd, String localName) {
			String key = this.keyForAttr(localName);
			MethodContext cont = new MethodContext(mtd);
			this.mMethodMap.put(key, cont);
		}

		private void _addAppendChildMethod(Method mtd, String localName) {
			String key = this.keyForElement(localName);
			MethodContext cont = new MethodContext(mtd);
			this.mMethodMap.put(key, cont);
			this.mMethodList.add(cont);
		}
	}

}
