package ananas.blueprint4.core.lang;

public interface BPController extends BPNode {

	BPDocument bindOwnerDocument(BPDocument doc);

	BPType bindType(BPType type);

	Object createTarget();

	Object getTarget();

	Object getTarget(boolean create);

}
