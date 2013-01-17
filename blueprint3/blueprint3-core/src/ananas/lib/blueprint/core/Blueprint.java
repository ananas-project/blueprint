package ananas.lib.blueprint.core;

import java.io.IOException;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.xml.BPXmlException;

public abstract class Blueprint implements IBlueprint {

	private static Blueprint s_inst;

	public static Blueprint getInstance() {
		Blueprint inst = s_inst;
		if (inst == null) {
			inst = BlueprintLoader.loadInstance();
			s_inst = inst;
		}
		return inst;
	}

	public static BPDocument loadDocument(String uri) throws IOException,
			BPXmlException {
		IBlueprint bp = Blueprint.getInstance();
		return bp.loadDocumentByURI(uri);
	}

}
