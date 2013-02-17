package ananas.lib.blueprint.loader.eom;

import java.util.HashMap;
import java.util.Map;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.loader.eom.target.ITargetNode;
import ananas.lib.blueprint.loader.eom.target.Tar_class;
import ananas.lib.blueprint.loader.eom.target.Tar_eom;
import ananas.lib.blueprint.loader.eom.target.Tar_namespace;
import ananas.lib.blueprint.loader.eom.target.util.TargetTravel;
import ananas.lib.blueprint.loader.eom.target.util.TargetTravelCallback;

public class MyBpnsFactory {

	private final BPEnvironment mEnvi;
	private final Tar_eom mModel;

	public MyBpnsFactory(BPEnvironment envi, Tar_eom model) {
		this.mEnvi = envi;
		this.mModel = model;
		this.mTempClassMap = new HashMap<String, MyTempClass>();
		this.mTempNsMap = new HashMap<String, MyTempNS>();
	}

	public BPNamespace[] build() {

		TargetTravel tt = new TargetTravel();

		tt.go(this.mModel, new MyPreload());

		// TODO Auto-generated method stub
		return null;
	}

	class MyPreload implements TargetTravelCallback {

		@Override
		public void findChild(ITargetNode child, ITargetNode parent) {
			// TODO Auto-generated method stub

			// System.out.println(child + ".parent  =  " + parent);

			// set parent
			child.setParent(parent);

			// create temp object

			if (child instanceof Tar_namespace) {
				Tar_namespace tar = (Tar_namespace) child;
				MyTempNS tmpNS = new MyTempNS(tar);
				String tid = tar.getTargetId();
				MyBpnsFactory.this.mTempNsMap.put(tid, tmpNS);

				System.out.println("new ns : " + tar);

			} else if (child instanceof Tar_class) {
				Tar_class tar = (Tar_class) child;
				MyTempClass tmpCls = new MyTempClass(tar);
				String tid = tar.getTargetId();
				MyBpnsFactory.this.mTempClassMap.put(tid, tmpCls);

				System.out.println("new cls : " + tar);
			}

		}
	}

	final Map<String, MyTempNS> mTempNsMap;
	final Map<String, MyTempClass> mTempClassMap;

	class MyTempNS {

		public MyTempNS(Tar_namespace tar) {
		}
	}

	class MyTempClass {

		public MyTempClass(Tar_class tar) {
		}
	}

}
