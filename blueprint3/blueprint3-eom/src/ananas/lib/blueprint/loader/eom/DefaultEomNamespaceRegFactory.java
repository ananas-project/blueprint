package ananas.lib.blueprint.loader.eom;

import java.util.ArrayList;
import java.util.List;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;
import ananas.lib.blueprint.core.util.IMacroProperties;
import ananas.lib.blueprint.loader.eom.target.Tar_class;
import ananas.lib.blueprint.loader.eom.target.Tar_eom;
import ananas.lib.blueprint.loader.eom.target.Tar_namespace;

class DefaultEomNamespaceRegFactory implements IEomNamespaceRegFactory {

	@Override
	public IEomNamespaceReg newReg(Tar_eom teom) {
		return new MyEom(teom);
	}

	class MyEom implements IEomNamespaceReg {

		private final Tar_eom mEom;
		private final List<MyNs> mListNS = new ArrayList<MyNs>();

		public MyEom(Tar_eom teom) {
			this.mEom = teom;
		}

		@Override
		public void register(BPEnvironment envi) {
			for (MyNs ns : this.mListNS) {
				ns.register(envi);
			}
		}

		@Override
		public void load(BPEnvironment envi) {
			List<Tar_namespace> tnsList = this.mEom.listNamespaces();
			for (Tar_namespace tns : tnsList) {
				MyNs ns = new MyNs(this, tns);
				ns.load(envi);
				this.mListNS.add(ns);
			}
		}

		@Override
		public void check(BPEnvironment envi) {
			for (MyNs ns : this.mListNS) {
				ns.check(envi);
			}
		}
	}

	class MyNs implements IEomNamespaceReg {

		private final MyEom mParent;
		private final Tar_namespace mTarget;
		private BPNamespace mBpNs;
		private final List<MyClass> mListClasses = new ArrayList<MyClass>();

		public MyNs(MyEom myEom, Tar_namespace tns) {
			this.mParent = myEom;
			this.mTarget = tns;
		}

		@Override
		public void register(BPEnvironment envi) {
			for (MyClass cls : this.mListClasses) {
				cls.register(envi);
			}
		}

		public IMacroProperties getProperties() {
			return this.mTarget.getProperties();
		}

		public BPNamespace getBpNamespace() {
			BPNamespace ns = this.mBpNs;
			if (ns == null) {
				this.mBpNs = ns;
			}
			return ns;
		}

		@Override
		public void load(BPEnvironment envi) {
			IMacroProperties props = this.mTarget.getProperties();

			// ns
			String uri = props.get(Const.ns_uri, false, null);
			String defaultPrefix = props.get(Const.ns_default_prefix, false,
					null);
			this.mBpNs = envi.getImplementation().createNamespace(envi, uri,
					defaultPrefix);

			// members
			List<Tar_class> tclassList = this.mTarget.listMemberClasses();
			for (Tar_class tcls : tclassList) {
				MyClass cls = new MyClass(this, tcls);
				cls.load(envi);
				this.mListClasses.add(cls);
			}

		}

		@Override
		public void check(BPEnvironment envi) {
			for (MyClass cls : this.mListClasses) {
				cls.check(envi);
			}
		}
	}

	class MyClass implements IEomNamespaceReg {

		private final MyNs mParent;
		private final Tar_class mTarget;
		private Class<?> mTargetClass;
		private Class<?> mCtrlClass;
		private BPType mType;

		public MyClass(MyNs myNs, Tar_class tcls) {
			this.mParent = myNs;
			this.mTarget = tcls;
		}

		public BPType getBpType() {
			BPType type = this.mType;
			if (type == null) {
				BPNamespace ownerNS = this.mParent.getBpNamespace();
				String localName = this.mTarget.getLocalName();
				Class<?> ctrlClass = this.getCtrlClass();
				Class<?> targetClass = this.getTargetClass();
				type = new MyBpType(ownerNS, localName, ctrlClass, targetClass);
				// ownerNS.registerType(type);
				this.mType = type;
			}
			return type;
		}

		public Class<?> getTargetClass() {
			Class<?> cls = this.mTargetClass;
			if (cls == null) {
				cls = this.classForName(new ClassProfile() {

					@Override
					public String getKeyForDefault() {
						return Const.ns_default_target_class;
					}
				});
				this.mTargetClass = cls;
			}
			return cls;
		}

		private Class<?> classForName(ClassProfile classProfile) {

			String javaName = this.mTarget.getJavaName();
			IMacroProperties props = this.mParent.getProperties();
			props.put(Const.ns_java_name, javaName);
			String keyForDefault = classProfile.getKeyForDefault();
			String className;
			if (keyForDefault.equals(Const.ns_default_target_class)) {
				// target default
				className = this.mTarget.getTargetClass();
			} else {
				// ctrl default
				className = this.mTarget.getControllerClass();
			}
			if (className == null) {
				className = props.get(keyForDefault, false, null);
			}
			className = props.processMacro(className);

			try {
				return Class.forName(className);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		public Class<?> getCtrlClass() {
			Class<?> cls = this.mCtrlClass;
			if (cls == null) {
				cls = this.classForName(new ClassProfile() {

					@Override
					public String getKeyForDefault() {
						return Const.ns_default_controller_class;
					}
				});
				this.mCtrlClass = cls;
			}
			return cls;
		}

		@Override
		public void register(BPEnvironment envi) {
			BPType type = this.getBpType();
			System.out.println("reg bp type : " + type);
		}

		@Override
		public void load(BPEnvironment envi) {
			BPType type = this.getBpType();
			System.out.println("load bp type : " + type);
		}

		@Override
		public void check(BPEnvironment envi) {
			BPType type = this.getBpType();
			System.out.println("check bp type : " + type);
		}

	}

	interface ClassProfile {
		String getKeyForDefault();
	}

}
