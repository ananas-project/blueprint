package ananas.lib.blueprint.core.lang;

public interface BPController {

	BPType getBPClass();

	boolean bindBPClass(BPType bpClass);

	Object getTarget();

	Object getTarget(boolean create);

	Object createTarget();

	boolean bindTarget(Object target);
}
