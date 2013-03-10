package ananas.lib.blueprint3.core.lang;

public interface BPController {

	BPType getType();

	boolean bindType(BPType bpClass);

	Object getTarget();

	Object getTarget(boolean create);

	Object createTarget();

	boolean bindTarget(Object target);
}
