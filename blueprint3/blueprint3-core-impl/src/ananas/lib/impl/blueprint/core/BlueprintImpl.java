package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPEnvironment;

public class BlueprintImpl extends Blueprint {

	private BPEnvironment mDefaultEnvironment;

	@Override
	public BPEnvironment defaultEnvironment() {
		BPEnvironment envi = this.mDefaultEnvironment;
		if (envi == null) {
			envi = new BPEnvironmentImpl();
			this.mDefaultEnvironment = envi;
		}
		return envi;
	}

	@Override
	public BPDocument loadDocumentByURI(String uri) {
		final
		BPEnvironment envi = this.defaultEnvironment() ;
	 BPDocument	doc = envi.getImplementation().newDocument( envi  ,  uri ) ;
		return doc;
	}

}
