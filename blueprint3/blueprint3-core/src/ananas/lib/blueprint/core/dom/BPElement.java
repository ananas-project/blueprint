package ananas.lib.blueprint.core.dom;

public interface BPElement extends BPNode {

	boolean setAttribute(BPAttribute attr);

	void tagBegin();

	void tagEnd();

}
