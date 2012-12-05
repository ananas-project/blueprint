package ananas.lib.blueprint2.awt.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Awt_responseChain implements IResponseChain, ActionListener {

	private final List<IResponseChainNode> mList;
	private IResponseChainNode mFirst;

	public Awt_responseChain() {
		this.mList = new ArrayList<IResponseChainNode>();
	}

	@Override
	public boolean appendNode(IResponseChainNode node) {
		boolean rlt = this.mList.add(node);
		if (rlt) {
			this._rebuildChain();
		}
		return rlt;
	}

	@Override
	public boolean removeNode(IResponseChainNode node) {
		boolean rlt = this.mList.remove(node);
		if (rlt) {
			this._rebuildChain();
		}
		return rlt;
	}

	private void _rebuildChain() {
		IResponseChainNode prev = null;
		IResponseChainNode first = null;
		for (IResponseChainNode item : this.mList) {
			if (first == null) {
				first = item;
			} else {
				prev.setNext(item);
			}
			item.setNext(null);
			prev = item;
		}
		this.mFirst = first;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IResponseChainNode first = this.mFirst;
		final boolean rlt;
		if (first != null) {
			rlt = first.processEvent(e);
		} else {
			rlt = IResponseChainNode.GOTO_NEXT;
		}
		if (rlt == IResponseChainNode.GOTO_NEXT) {
			System.err.println("warning: the action not handler : " + e);
		}
	}

}
