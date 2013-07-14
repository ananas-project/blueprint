package ananas.blueprint4.core.lang;

import org.w3c.dom.Node;

public interface BPNode {

	boolean appendChild(BPNode node);

	/**
	 * @return the old parent
	 * */
	BPNode setParent(BPNode parent);

	/**
	 * @return the current parent
	 * */
	BPNode getParent();

	/**
	 * @return the owner
	 * */
	BPDocument getOwnerDocument();

	// bind

	boolean bind(Node node);

	boolean bind(BPDocument doc);

	boolean bind(BPType type);
}
