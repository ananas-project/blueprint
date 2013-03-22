package ananas.lib.blueprint3.awt.helper;

import java.awt.event.ActionEvent;

public class Tar_responseChainNode implements IResponseChainNode {

	private IResponseChainNode mNext;
	private IResponseChainNode mHook;

	@Override
	public void setHook(IResponseChainNode hook) {
		this.mHook = hook;
	}

	@Override
	public IResponseChainNode getHook() {
		return this.mHook;
	}

	@Override
	public IResponseChainNode getNext() {
		return this.mNext;
	}

	@Override
	public void setNext(IResponseChainNode next) {
		this.mNext = next;
	}

	@Override
	public boolean processEvent(ActionEvent e) {
		IResponseChainNode hook = this.mHook;
		IResponseChainNode next = this.mNext;
		boolean rlt = IResponseChainNode.GOTO_NEXT;
		if (hook != null) {
			rlt = hook.processEvent(e);
			if (rlt == IResponseChainNode.DONE) {
				return rlt;
			}
		}
		if (next != null) {
			rlt = next.processEvent(e);
		}
		return rlt;
	}
}
