package ananas.lib.blueprint.loader.eom;

import ananas.lib.blueprint.core.util.nsloader.BPNamespaceLoader;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceLoaderFactory;

public class EomNamespaceLoaderFactory implements BPNamespaceLoaderFactory {

	private BPNamespaceLoader mLoader;

	@Override
	public BPNamespaceLoader getLoader() {
		if (this.mLoader == null) {
			this.mLoader = new EomNamespaceLoader();
		}
		return this.mLoader;
	}

}
