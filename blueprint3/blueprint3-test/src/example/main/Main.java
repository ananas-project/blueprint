package example.main;

import java.lang.reflect.Method;

import javax.swing.JFrame;

import ananas.lib.blueprint.awt.AwtNamespaceInfo;
import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.loader.eom.EomReflectInfo;
import ananas.lib.blueprint.swing.CJFrame;

public class Main {

	public static void main(String arg[]) {

		Main m = new Main();
		m.testMain();
		// m.testReflex();

	}

	private void testReflex() {

		// Class<?> cls = javax.swing.JFrame.class;
		Class<?> cls = CJFrame.class;

		MyClassSpy spy = new MyClassSpy();
		spy.proc(cls);
	}

	class MyClassSpy {

		public void proc(Class<?> cls) {
			this.proc(cls, "");
		}

		public void proc(Class<?> cls, String tab) {

			if (cls == null) {
				return;
			}

			System.out.println(tab + cls);

			final String nextTab = tab + "    ";

			Class<?>[] ifs = cls.getInterfaces();
			for (Class<?> aif : ifs) {
				this.proc(aif, nextTab + "[ifs]");
			}

			Method[] mtds = cls.getMethods();
			for (Method mtd : mtds) {
				System.out.println(tab + mtd);
			}

			this.proc(cls.getSuperclass(), nextTab);

		}

	}

	private void testMain() {
		System.out.println("the Begin");

		try {

			BPEnvironment bpenv = Blueprint.getInstance().defaultEnvironment();
			bpenv.loadNamespace(EomReflectInfo.class, true);
			bpenv.loadNamespace(AwtNamespaceInfo.class, true);
			// bpenv.loadNamespace(SwingNamespaceInfo.class, true);

			/*
			BPDocument doc = Blueprint
					.loadDocument("resource:///test-swing.xml");
			JFrame frame = (JFrame) doc.getRootElement().getTarget();
			frame.setVisible(true);
			*/

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("the End");

	}
}
