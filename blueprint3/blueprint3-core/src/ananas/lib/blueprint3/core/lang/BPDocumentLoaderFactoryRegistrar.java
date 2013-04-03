package ananas.lib.blueprint3.core.lang;

public interface BPDocumentLoaderFactoryRegistrar {

	BPDocumentLoaderFactory getFactory(String key);

	BPDocumentLoaderFactory getFactory(String key, boolean enableDefault);

	void registerFactory(String key, BPDocumentLoaderFactory factory);

	void setDefaultFactory(BPDocumentLoaderFactory factory);

}
