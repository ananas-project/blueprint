package ananas.blueprint4.core.lang;

public interface BPElement extends BPNode {

	Object createTarget();

	Object getTarget();

	Object getTarget(boolean create);

	void tagBegin();

	void tagEnd();

}
