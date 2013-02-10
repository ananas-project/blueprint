package ananas.lib.blueprint.loader.eom;

import ananas.lib.blueprint.core.lang.BPEnvironment;

public interface IEomNamespaceReg {

	void load(BPEnvironment envi);

	void register(BPEnvironment envi);

	void check(BPEnvironment envi);

}
