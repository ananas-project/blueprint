package ananas.blueprint4.core.lang;

public interface BPType {

	BPNamespace getOwnerNamespace();

	String getLocalName();

	Class<?> getControllerClass();

	Class<?> getTargetClass();

	BPElement createController(BPDocument doc);

}
