package test.ananas.lib.blueprint3.swing;

import java.net.URI;

import javax.swing.JFrame;

import ananas.lib.blueprint3.Blueprint;
import ananas.lib.blueprint3.awt.AwtNamespaceInfo;
import ananas.lib.blueprint3.awt.swing.SwingNamespaceInfo;
import ananas.lib.blueprint3.dom.BPDocument;
import ananas.lib.blueprint3.lang.BPEnvironment;
import ananas.lib.blueprint3.loader.eom.EomReflectInfo;

public class Main {

	public static void main(String[] arg) {

		try {
			String uri = R.file.Main_xml;
			BPEnvironment envi = Blueprint.Util.getInstance()
					.defaultEnvironment();

			Class<?>[] info_list = { EomReflectInfo.class,
					AwtNamespaceInfo.class, SwingNamespaceInfo.class };
			for (Class<?> info : info_list) {
				envi.loadNamespace(info, true);
			}

			BPDocument doc = envi.loadDocument(URI.create(uri));
			JFrame frame = (JFrame) doc.getRootElement().getTarget(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
