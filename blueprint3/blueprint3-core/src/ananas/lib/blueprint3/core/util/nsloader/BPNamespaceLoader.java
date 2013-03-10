package ananas.lib.blueprint3.core.util.nsloader;

import ananas.lib.blueprint3.core.lang.BPEnvironment;
import ananas.lib.blueprint3.core.lang.BlueprintException;

public interface BPNamespaceLoader {

	void load(BPEnvironment environment, BPNamespaceInfo info)
			throws BlueprintException;

}
