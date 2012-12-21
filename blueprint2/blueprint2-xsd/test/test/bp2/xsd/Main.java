package test.bp2.xsd;

import ananas.lib.blueprint2.Blueprint2;
import ananas.lib.blueprint2.dom.IDocument;

public class Main {

	public static void main(String[] arg) {

		(new Main()).run();
	}

	private void run() {
		System.out.println(this + ".begin");
		try {
			Blueprint2 bp = Blueprint2.getInstance();
			IDocument doc = bp.loadDocument("");

			doc.findElementById("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this + ".end");
	}
}
