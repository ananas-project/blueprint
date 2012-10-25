package bp2.swing.demo2.gui;

import java.io.IOException;

import ananas.lib.blueprint2.Blueprint2;
import ananas.lib.blueprint2.dom.IDocument;

public class Bp2Ctrl {

	public IDocument loadDocument(String uri) {
		try {
			return Blueprint2.getInstance().loadDocument(uri);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
