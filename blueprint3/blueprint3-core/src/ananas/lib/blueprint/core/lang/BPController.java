package ananas.lib.blueprint.core.lang;

public interface BPController {

	BPType getType();

	boolean bindType(BPType bpClass);

	Object getTarget();

	Object getTarget(boolean create);

	Object createTarget();

	boolean bindTarget(Object target);
}
