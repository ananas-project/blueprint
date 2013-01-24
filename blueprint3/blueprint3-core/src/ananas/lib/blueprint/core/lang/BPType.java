package ananas.lib.blueprint.core.lang;

public interface BPType {

	Class<?> getTargetClass();

	Class<?> getControllerClass();

	BPType getAttributeType(String uri, String localName);

	String getLocalName();

	BPNamespace getOwnerNamespace();

}
