package ananas.lib.blueprint3.core.lang;

public interface BPNamespace {

	String getNamespaceURI();

	String getDefaultPrefix();

	BPType getType(String localName);

	BPEnvironment getOwnerEnvironment();

	boolean registerType(BPType bpType);

	boolean unregisterType(BPType bpType);

}
