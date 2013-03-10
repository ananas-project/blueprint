package ananas.lib.impl.blueprint3.core;

import ananas.lib.blueprint3.core.Blueprint;
import ananas.lib.blueprint3.core.BlueprintFactory;

public class BlueprintFactoryImpl implements BlueprintFactory {

	@Override
	public Blueprint newBlueprint() {
		return   new   BlueprintImpl  ()   ;
	}

}
