package test.ananas.blueprint4.swing;

import java.io.InputStream;

import org.w3c.dom.Document;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.Blueprint;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.lib.io.Connector;
import ananas.lib.io.InputConnection;
import ananas.lib.util.logging.Logger;

public class TestBp4Swing implements Runnable {

	static final Logger log = Logger.Agent.getLogger();

	public static void main(String[] arg) {
		javax.swing.SwingUtilities.invokeLater(new TestBp4Swing());
	}

	@Override
	public void run() {
		try {
			BPContext envi = Blueprint.Util.getDefault().getEnvironment();
			String systemId = "resource:///test/abc.xml";
			{
				InputConnection conn = (InputConnection) Connector.Factory
						.getDefault().open(systemId);
				InputStream is = conn.getInputStream();
				Document doc = envi.getDocumentBuilderFactory()
						.newDocumentBuilder().parse(is, systemId);
			}
			BPDocument doc = envi.loadBPDocument(systemId);
			Object root = doc.getRootController().getTarget(true);
			log.info(root + "");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
