package impl.ananas.blueprint4.core;

import ananas.blueprint4.core.BPEnvironment;
import ananas.blueprint4.core.Blueprint;

public class BlueprintImpl implements Blueprint {

	private BPEnvironment _envi;

	@Override
	public BPEnvironment getEnvironment() {
		BPEnvironment envi = _envi;
		if (envi == null) {
			_envi = envi = new BPEnvironmentImpl();
		}
		return envi;
	}

}
