package ananas.lib.impl.blueprint3.core;

import ananas.lib.blueprint3.core.Blueprint;
import ananas.lib.blueprint3.core.lang.BPEnvironment;

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
