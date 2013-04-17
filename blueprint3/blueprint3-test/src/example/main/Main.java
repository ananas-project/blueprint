package example.main;

import java.lang.reflect.Method;

import javax.swing.JFrame;

import ananas.lib.blueprint3.Blueprint;
import ananas.lib.blueprint3.awt.AwtNamespaceInfo;
import ananas.lib.blueprint3.awt.swing.CJFrame;
import ananas.lib.blueprint3.awt.swing.SwingNamespaceInfo;
import ananas.lib.blueprint3.dom.BPDocument;
import ananas.lib.blueprint3.lang.BPEnvironment;
import ananas.lib.blueprint3.loader.eom.EomReflectInfo;

public class Main {

	public static void main(String arg[]) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				long ms1 = System.currentTimeMillis();

				Main m = new Main();
				m.testMain();
				// m.testReflex();

				long ms2 = System.currentTimeMillis();
				System.out.println((ms2 - ms1) + "ms");

			}
		});

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

			BPEnvironment bpenv = Blueprint.Util.getInstance()
					.defaultEnvironment();
			bpenv.loadNamespace(EomReflectInfo.class, true);
			bpenv.loadNamespace(AwtNamespaceInfo.class, true);
			bpenv.loadNamespace(SwingNamespaceInfo.class, true);

			System.out.println("now load a testing xml doc.");

			BPDocument doc = Blueprint.Util
					.loadDocument("resource:///test-swing.xml");
			JFrame frame = (JFrame) doc.getRootElement().getTarget();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("the End");

	}
}
