package example.main;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;

public class Main {

	public static void main(String arg[]) {

		System.out.println("the Begin");

		try {
			BPDocument doc = Blueprint.loadDocument("resource:///test.xml");
			BPElement element = doc.getRootElement();
			System.out.println(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("the End");

	}
}
