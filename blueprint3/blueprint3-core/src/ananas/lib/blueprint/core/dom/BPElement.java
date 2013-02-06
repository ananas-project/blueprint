package ananas.lib.blueprint.core.dom;

import ananas.lib.blueprint.core.lang.BPController;

public interface BPElement extends BPNode, BPController {

	boolean setAttribute(BPAttribute attr);

	void tagBegin();

	void tagEnd();

}
