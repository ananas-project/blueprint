package ananas.lib.blueprint.loader.eom.boot;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BlueprintException;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceInfo;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceLoader;
import ananas.lib.blueprint.loader.eom.target.TElement;
import ananas.lib.blueprint.loader.eom.target.TNamespace;

public class BootLoader implements BPNamespaceLoader {

	@Override
	public void load(BPEnvironment environment, BPNamespaceInfo info)
			throws BlueprintException {

		TNamespace ns1 = new TNamespace();

		TElement ele = ns1.createElement("attribute");

		BPNamespace ns2 = ns1.genBPNamespace(environment);
		environment.getNamespaceRegistrar().registerNamespace(ns2);

	}

}
