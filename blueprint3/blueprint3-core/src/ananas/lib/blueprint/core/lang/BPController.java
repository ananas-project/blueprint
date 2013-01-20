package ananas.lib.blueprint.core.lang;

public interface BPController {

	BPClass getBPClass();

	Object getTarget();

	Object getTarget(boolean create);

}
