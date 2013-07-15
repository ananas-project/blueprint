package ananas.blueprint4.core.util;

import org.w3c.dom.Node;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPElement;
import ananas.blueprint4.core.lang.BPNode;
import ananas.blueprint4.core.lang.BPType;
import ananas.lib.util.logging.Logger;

public class AbstractElement implements BPElement {

	final static Logger log = Logger.Agent.getLogger();

	private BPNode _parent;
	private BPDocument _ownerDoc;
	private Object _target;
	private BPType _type;

	private Node _domNode;

	@Override
	public boolean appendChild(BPNode node) {
		return false;
	}

	@Override
	public BPNode setParent(BPNode parent) {
		if (parent instanceof BPElement) {
			BPNode old = this._parent;
			this._parent = parent;
			return old;
		} else {
			return null;
		}
	}

	@Override
	public BPNode getParent() {
		return this._parent;
	}

	@Override
	public BPDocument getOwnerDocument() {
		return this._ownerDoc;
	}

	@Override
	public boolean bind(Node node) {
		if (this._domNode == null) {
			if (node != null) {
				this._domNode = node;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean bind(BPDocument doc) {
		if (this._ownerDoc == null) {
			if (doc != null) {
				this._ownerDoc = doc;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean bind(BPType type) {
		if (this._type == null) {
			if (type != null) {
				this._type = type;
				return true;
			}
		}
		return false;
	}

	@Override
	public Object createTarget() {
		try {
			Class<?> cls = this.getType().getTargetClass();
			return cls.newInstance();
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	@Override
	public Object getTarget() {
		return this._target;
	}

	@Override
	public Object getTarget(boolean create) {
		Object target = this._target;
		if (target == null) {
			if (create) {
				this._target = target = this.createTarget();
			}
		}
		return target;
	}

	@Override
	public BPType getType() {
		return this._type;
	}

	@Override
	public Node getDOMNode() {
		return this._domNode;
	}

	@Override
	public final void tagBegin() {
		this.onTagBegin();
	}

	private void onTagBegin() {
	}

	@Override
	public final void tagEnd() {
		this.onTagEnd();
	}

	private void onTagEnd() {
	}

}
