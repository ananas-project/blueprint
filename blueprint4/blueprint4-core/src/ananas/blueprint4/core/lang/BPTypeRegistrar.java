package ananas.blueprint4.core.lang;

public interface BPTypeRegistrar {

	String getTypeName(String uri, String localName);

	BPType getType(String typeName);

	BPType getType(String uri, String localName);

	BPNamespace getNamespace(String uri);

	void register(BPType type);

	void register(BPNamespace ns);

	void register(String nsURI, String className);

}
