package ananas.lib.blueprint3.core;

import java.io.IOException;

import org.xml.sax.SAXException;

import ananas.lib.blueprint3.core.dom.BPDocument;
import ananas.lib.blueprint3.core.lang.BPEnvironment;

public abstract class Blueprint implements IBlueprint {

	private static Blueprint s_inst;

	public static Blueprint getInstance() {
		Blueprint inst = s_inst;
		if (inst == null) {
			inst = Private_BlueprintLoader.loadInstance();
			s_inst = inst;
		}
		return inst;
	}

	public static BPDocument loadDocument(String uri) throws IOException,
			SAXException {

		BPEnvironment envi = Blueprint.getInstance().defaultEnvironment();
		return envi.getDocumentLoaderFactory().newLoader()
				.loadDocument(envi, uri);
	}

}
