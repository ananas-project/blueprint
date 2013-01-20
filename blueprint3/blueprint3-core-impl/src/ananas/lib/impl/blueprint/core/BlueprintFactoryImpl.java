package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.BlueprintFactory;

public class BlueprintFactoryImpl implements BlueprintFactory {

	@Override
	public Blueprint newBlueprint() {
		return   new   BlueprintImpl  ()   ;
	}

}
