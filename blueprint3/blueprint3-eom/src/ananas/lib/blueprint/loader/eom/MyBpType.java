package ananas.lib.blueprint.loader.eom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.dom.BPNode;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

class MyBpType implements BPType {

	private final Class<?> mTargetClass;
	private final Class<?> mCtrlClass;
	private final String mLocalName;
	private final BPNamespace mOwnerNS;

	private final List<MethodContext> mMethodList = new ArrayList<MethodContext>();
	private final Map<String, MethodContext> mMethodMap = new HashMap<String, MethodContext>();

	public MyBpType(BPNamespace ownerNS, String localName, Class<?> ctrlClass,
			Class<?> targetClass) {
		this.mOwnerNS = ownerNS;
		this.mLocalName = localName;
		this.mCtrlClass = ctrlClass;
		this.mTargetClass = targetClass;
		this._loadMethods();
	}

	private void _loadMethods() {
		Method[] methods = this.mCtrlClass.getMethods();
		for (Method method : methods) {
			String name = method.getName();
			if (name == null) {

			} else if (name.startsWith(Const.add_child_method_prefix)) {
				String prefix = Const.add_child_method_prefix;
				String localName = name.substring(prefix.length());
				this._add_method_for_attr(localName, method);

			} else if (name.startsWith(Const.set_attr_method_prefix)) {
				String prefix = Const.set_attr_method_prefix;
				String localName = name.substring(prefix.length());
				this._add_method_for_element(localName, method);

			} else {
			}
		}
	}

	private void _add_method_for_element(String localName, Method method) {
		MethodContext mc = new MethodContext(method);
		String key = this.keyForElement(localName);
		this.mMethodMap.put(key, mc);
		this.mMethodList.add(mc);
	}

	private void _add_method_for_attr(String localName, Method method) {
		MethodContext mc = new MethodContext(method);
		String key = this.keyForAttr(localName);
		this.mMethodMap.put(key, mc);
	}

	private static class MethodContext {

		private final Method mMethod;
		private final Class<?> mParamType;

		public MethodContext(Method method) {
			this.mMethod = method;
			this.mParamType = this._loadParamType(method);
		}

		private Class<?> _loadParamType(Method method) {
			Class<?>[] ps = method.getParameterTypes();
			if (ps.length != 1) {
				throw new RuntimeException("bad method : " + method);
			}
			return ps[0];
		}

		public Method getMethod() {
			return mMethod;
		}

		public Class<?> getParamType() {
			return mParamType;
		}

	}

	@Override
	public Class<?> getTargetClass() {
		return this.mTargetClass;
	}

	@Override
	public Class<?> getControllerClass() {
		return this.mCtrlClass;
	}

	@Override
	public String getLocalName() {
		return this.mLocalName;
	}

	@Override
	public BPNamespace getOwnerNamespace() {
		return this.mOwnerNS;
	}

	@Override
	public boolean appendChildToParent(BPElement parent, BPNode child) {
		String key = this.keyForElement(child.getLocalName());
		MethodContext method = this.mMethodMap.get(key);
		if (method == null) {
			for (MethodContext mc : this.mMethodList) {
				Class<?> type1 = mc.getParamType();
				if (type1.isInstance(child)) {
					method = mc;
					break;
				}
			}
		}
		try {
			boolean rlt = (Boolean) method.getMethod().invoke(parent, child);
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
		MethodContext method = this.mMethodMap.get(key);
		try {
			boolean rlt = (Boolean) method.getMethod().invoke(parent, attr);
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

	public String toString() {
		String uri = this.mOwnerNS.getNamespaceURI();
		return ("[" + this.getClass().getName() + " fullName=" + uri + "#"
				+ this.getLocalName() + " target=" + this.mTargetClass
				+ " ctrl=" + this.mCtrlClass + "]");

	}

}