package impl.ananas.blueprint4.core.dom;

import org.w3c.dom.Node;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPNode;
import ananas.blueprint4.core.lang.BPText;
import ananas.blueprint4.core.lang.BPType;

public class BPTextImpl implements BPText {

	private String _data;

	public BPTextImpl(String data) {
		this._data = data;
	}

	@Override
	public boolean appendChild(BPNode node) {
		// TODO Auto-generated method stub
		return false;
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
	public String getData() {
		return this._data;
	}

}
