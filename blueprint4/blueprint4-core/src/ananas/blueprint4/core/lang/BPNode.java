package ananas.blueprint4.core.lang;

public interface BPNode {

	BPNode appendChild(BPNode node);

	BPNode setParent(BPNode parent);

	BPNode getParent();
}
