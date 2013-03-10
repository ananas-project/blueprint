package ananas.lib.blueprint3.core.dom;

import ananas.lib.blueprint3.core.lang.BPController;

public interface BPElement extends BPNode, BPController {

	boolean setAttribute(BPAttribute attr);

	void tagBegin();

	void tagEnd();

}
