package bp2.swing.demo1;

import java.io.IOException;

import javax.swing.JFrame;

import ananas.lib.blueprint2.Blueprint2;
import ananas.lib.blueprint2.dom.IDocument;

public class Demo1_helloworld {

	public static void main(String args[]) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Demo1_helloworld demo = new Demo1_helloworld();
				demo.show();
			}
		});

	}

	private final JFrame mFrame;

	public Demo1_helloworld() {
		String docURI = "resource:///bp2/swing/demo1/Demo1_helloworld.xml";
		IDocument doc = null;
		try {
			doc = Blueprint2.getInstance().loadDocument(docURI);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.mFrame = (JFrame) doc.findTargetById("root");
		this.mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void show() {
		this.mFrame.setVisible(true);
	}

}
