package ananas.lib.blueprint.loader.eom;

import java.util.List;

import ananas.lib.blueprint.core.lang.BPEnvironment;
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

		public MyEom(Tar_eom teom) {
			this.mEom = teom;
		}

		@Override
		public void regNamespaces(BPEnvironment envi) {

			List<Tar_namespace> tnsList = this.mEom.listNamespaces();
			for (Tar_namespace tns : tnsList) {
				MyNs ns = new MyNs(this, tns);
				ns.regNamespaces(envi);
			}

		}
	}

	class MyNs implements IEomNamespaceReg {

		private final MyEom mParent;
		private final Tar_namespace mTarget;

		public MyNs(MyEom myEom, Tar_namespace tns) {
			this.mParent = myEom;
			this.mTarget = tns;
		}

		@Override
		public void regNamespaces(BPEnvironment envi) {

			List<Tar_class> tclassList = this.mTarget.listMemberClasses();
			for (Tar_class tcls : tclassList) {
				MyClass cls = new MyClass(this, tcls);
				cls.regNamespaces(envi);
			}

		}
	}

	class MyClass implements IEomNamespaceReg {

		private final MyNs mParent;
		private final Tar_class mTarget;

		public MyClass(MyNs myNs, Tar_class tcls) {
			this.mParent = myNs;
			this.mTarget = tcls;
		}

		@Override
		public void regNamespaces(BPEnvironment envi) {
			// TODO Auto-generated method stub

		}
	}
}
