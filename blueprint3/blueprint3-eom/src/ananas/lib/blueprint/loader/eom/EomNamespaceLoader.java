package ananas.lib.blueprint.loader.eom;

import java.io.IOException;
import java.io.InputStream;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPDocumentLoader;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BlueprintException;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceInfo;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceLoader;

public class EomNamespaceLoader implements BPNamespaceLoader {

	@Override
	public void load(BPEnvironment envi, BPNamespaceInfo info)
			throws BlueprintException {

		String xmlfile = info.getProperty("eom.xml");
		InputStream in = info.getClass().getResourceAsStream(xmlfile);

		try {

			BPDocumentLoader docLdr = envi.getDocumentLoaderFactory()
					.newLoader();
			BPDocument doc = docLdr.loadDocument(envi, in, "");
			System.out.println(doc);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (in != null)
				in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
