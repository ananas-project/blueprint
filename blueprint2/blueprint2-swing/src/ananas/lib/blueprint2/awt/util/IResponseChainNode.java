package ananas.lib.blueprint2.awt.util;

import java.awt.event.ActionEvent;

public interface IResponseChainNode {

	IResponseChainNode getNext();

	void setNext(IResponseChainNode next);

	IResponseChainNode getHook();

	void setHook(IResponseChainNode hook);

	/**
	 * the return value of processEvent
	 * */

	boolean DONE = true;
	boolean GOTO_NEXT = false;

	/**
	 * @return true=done ; false=goto next.
	 * */

	boolean processEvent(ActionEvent e);

}
