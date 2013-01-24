package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.lang.BPEnvironment;

public class BlueprintImpl extends Blueprint {

	private BPEnvironment mDefaultEnvironment;

	@Override
	public BPEnvironment defaultEnvironment() {
		BPEnvironment envi = this.mDefaultEnvironment;
		if (envi == null) {
			envi = new EnvironmentImpl();
			this.mDefaultEnvironment = envi;
		}
		return envi;
	}

}
