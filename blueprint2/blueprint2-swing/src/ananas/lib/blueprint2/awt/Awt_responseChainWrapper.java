package ananas.lib.blueprint2.awt;

import ananas.lib.blueprint2.awt.util.IResponseChain;
import ananas.lib.blueprint2.awt.util.IResponseChainNode;
import ananas.lib.blueprint2.dom.INode;

public class Awt_responseChainWrapper extends ObjectWrapper {

	@Override
	public boolean onAppendChild(INode child) {

		if (child == null) {
			return false;

		} else if (child instanceof Awt_responseChainNodeWrapper) {
			this._appendNode((Awt_responseChainNodeWrapper) child);
			return true;

		} else {
			return super.onAppendChild(child);
		}
	}

	private void _appendNode(Awt_responseChainNodeWrapper child) {
		IResponseChainNode node = (IResponseChainNode) child.getTarget(true);
		IResponseChain chain = (IResponseChain) this.getTarget(true);
		chain.appendNode(node);
	}
}
