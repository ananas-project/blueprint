package ananas.lib.blueprint.core.dom;

import ananas.lib.blueprint.core.lang.BPController;

public interface BPNode extends BPController {

	BPNode appendChild(BPNode newChild);

	BPNode setParent(BPNode newParent);

}
