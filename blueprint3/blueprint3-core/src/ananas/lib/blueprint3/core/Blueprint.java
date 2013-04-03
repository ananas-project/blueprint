package ananas.lib.blueprint3.core;

import java.io.IOException;
import java.net.URI;

import ananas.lib.blueprint3.core.dom.BPDocument;
import ananas.lib.blueprint3.core.dom.BPDocumentGroup;
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

	public static BPDocument loadDocument(String uri) throws IOException {
		BPEnvironment envi = Blueprint.getInstance().defaultEnvironment();
		BPDocumentGroup group = envi.getImplementation().createDocumentGroup(
				envi);
		return group.openDocument(URI.create(uri), true, true);
	}

}
