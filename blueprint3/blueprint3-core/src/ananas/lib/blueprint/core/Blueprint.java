package ananas.lib.blueprint.core;

import ananas.lib.blueprint.core.dom.BPDocument;

public abstract class Blueprint implements IBlueprint {

	public static Blueprint getInstance() {
		return BlueprintAgentImpl._theInstance();
	}

	public static BPDocument loadDocument(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
