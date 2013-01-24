package ananas.lib.blueprint.core.dom;

import ananas.lib.blueprint.core.lang.BPController;

public interface BPNode extends BPController {

	boolean appendChild(BPNode newChild);

	boolean removeChild(BPNode theChild);

	void setParent(BPNode newParent);

	BPNode getParent();

	BPDocument getOwnerDocument();

	boolean bindOwnerDocument(BPDocument ownerDoc);

}
