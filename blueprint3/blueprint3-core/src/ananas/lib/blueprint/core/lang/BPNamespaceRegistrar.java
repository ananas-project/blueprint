package ananas.lib.blueprint.core.lang;

public interface BPNamespaceRegistrar {

	boolean registerNamespace(BPNamespace ns);

	boolean unregisterNamespace(BPNamespace ns);

	BPNamespace getNamespace(String nsURI);

}
