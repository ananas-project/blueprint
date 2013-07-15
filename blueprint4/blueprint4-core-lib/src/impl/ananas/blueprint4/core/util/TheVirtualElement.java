package impl.ananas.blueprint4.core.util;

import org.w3c.dom.Node;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPElement;
import ananas.blueprint4.core.lang.BPNode;
import ananas.blueprint4.core.lang.BPType;

public class TheVirtualElement implements BPElement {

	@Override
	public boolean appendChild(BPNode node) {
		return true;
	}

	@Override
	public BPNode setParent(BPNode parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BPNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BPDocument getOwnerDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BPType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getDOMNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bind(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bind(BPDocument doc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bind(BPType type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object createTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTarget(boolean create) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tagBegin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tagEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setAttribute(String uri, String localName, String value) {
		return true;
	}

}
