package ananas.lib.blueprint.core;

import ananas.lib.blueprint.core.dom.BPDocument;

public abstract class Blueprint implements IBlueprint {

	public static Blueprint getInstance() {
		return BlueprintLoader.loadInstance();
	}

	public static BPDocument loadDocument(String uri) {
		IBlueprint bp = Blueprint.getInstance();
		return bp.loadDocumentByURI(uri);
	}

}
