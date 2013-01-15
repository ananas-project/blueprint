package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.IBlueprintFactory;

public class BlueprintFactoryImpl implements IBlueprintFactory {

	@Override
	public Blueprint newBlueprint() {
		return   new   BlueprintImpl  ()   ;
	}

}
