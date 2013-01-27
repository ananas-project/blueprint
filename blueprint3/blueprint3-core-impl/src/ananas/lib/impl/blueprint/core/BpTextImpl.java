package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPNode;
import ananas.lib.blueprint.core.dom.BPText;
import ananas.lib.blueprint.core.lang.BPType;

public class BpTextImpl implements BPText {

	private final String mData;

	public BpTextImpl(String data) {
		this.mData = data;
	}

	@Override
	public boolean appendChild(BPNode newChild) {
		return false;
	}

	@Override
	public boolean removeChild(BPNode theChild) {
		return false;
	}

	@Override
	public void setParent(BPNode newParent) {
	}

	@Override
	public BPNode getParent() {
		return null;
	}

	@Override
	public BPDocument getOwnerDocument() {
		return null;
	}

	@Override
	public boolean bindOwnerDocument(BPDocument ownerDoc) {
		return false;
	}

	@Override
	public BPType getType() {
		return null;
	}

	@Override
	public boolean bindType(BPType bpClass) {
		return false;
	}

	@Override
	public Object getTarget() {
		return null;
	}

	@Override
	public Object getTarget(boolean create) {
		return null;
	}

	@Override
	public Object createTarget() {
		return null;
	}

	@Override
	public boolean bindTarget(Object target) {
		return false;
	}

	@Override
	public String getData() {
		return this.mData;
	}

}
