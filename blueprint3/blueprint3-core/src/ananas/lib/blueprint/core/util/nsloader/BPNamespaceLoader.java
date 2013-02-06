package ananas.lib.blueprint.core.util.nsloader;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BlueprintException;

public interface BPNamespaceLoader {

	void load(BPEnvironment environment, BPNamespaceInfo info)
			throws BlueprintException;

}
