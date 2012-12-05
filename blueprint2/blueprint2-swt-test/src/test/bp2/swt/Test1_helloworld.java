package test.bp2.swt;

import ananas.lib.blueprint2.Blueprint2;
import ananas.lib.blueprint2.dom.IDocument;

public class Test1_helloworld {

	public static void main(String[] arg) {

		try {

			String docURI = "resource:///test/bp2/swt/Test1_helloworld.xml";
			IDocument doc = Blueprint2.getInstance().loadDocument(docURI);

			// Display display = doc.findTargetById("root");
			// this.mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
