package ananas.lib.blueprint.core.lang;

public interface BPClass {

	Class<?> getTargetClass();

	Class<?> getControllerClass();

	String getLocalName();
}
