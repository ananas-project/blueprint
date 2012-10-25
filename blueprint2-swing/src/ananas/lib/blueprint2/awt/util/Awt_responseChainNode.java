package ananas.lib.blueprint2.awt.util;

import java.awt.event.ActionEvent;

public class Awt_responseChainNode implements IResponseChainNode {

	private IResponseChainNode mHook;
	private IResponseChainNode mNext;

	@Override
	public IResponseChainNode getNext() {
		return this.mNext;
	}

	@Override
	public void setNext(IResponseChainNode next) {
		this.mNext = next;
	}

	@Override
	public IResponseChainNode getHook() {
		return this.mHook;
	}

	@Override
	public void setHook(IResponseChainNode hook) {
		this.mHook = hook;
	}

	@Override
	public boolean processEvent(ActionEvent e) {
		final IResponseChainNode hook = this.mHook;
		if (hook != null) {
			final boolean rlt = hook.processEvent(e);
			if (rlt == IResponseChainNode.DONE) {
				return rlt;
			}
		}
		final IResponseChainNode next = this.mNext;
		if (next != null) {
			return next.processEvent(e);
		}
		return IResponseChainNode.GOTO_NEXT;
	}

}
