package ananas.lib.blueprint3.swing.helper;

import java.awt.event.ActionEvent;

public interface IResponseChainNode {

	void setHook(IResponseChainNode hook);

	IResponseChainNode getHook();

	IResponseChainNode getNext();

	void setNext(IResponseChainNode next);

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
