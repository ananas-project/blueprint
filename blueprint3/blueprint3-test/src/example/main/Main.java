package example.main;

import java.lang.reflect.Method;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.swing.SwingNamespaceInfo;

public class Main {

	public static void main(String arg[]) {

		Main m = new Main();
		m.testMain();
		// m.testReflex();

	}

	private void testReflex() {

		// Class<?> cls = javax.swing.JFrame.class;
		Class<?> cls = ananas.lib.blueprint.loader.eom.ctrl.Element_element_ctrl.class;

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
			// bpenv.loadNamespace(EomBootInfo.class, true);
			bpenv.loadNamespace(SwingNamespaceInfo.class, true);

			BPDocument doc = Blueprint.loadDocument("resource:///test.xml");
			BPElement element = doc.getRootElement();
			System.out.println(element);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("the End");

	}
}
