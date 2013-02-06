package ananas.lib.blueprint.core.dom;

public interface BPNode {

	boolean appendChild(BPNode newChild);

	boolean removeChild(BPNode theChild);

	void setParent(BPNode newParent);

	BPNode getParent();

	BPDocument getOwnerDocument();

	boolean bindOwnerDocument(BPDocument ownerDoc);

	String getLocalName();

	String getNamespaceURI();

}
