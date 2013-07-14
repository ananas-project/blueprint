package impl.ananas.blueprint4.core.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.BPDocumentImplementation;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPElement;
import ananas.blueprint4.core.lang.BPNode;
import ananas.blueprint4.core.lang.BPText;
import ananas.blueprint4.core.lang.BPType;

public class BPDocumentImpl implements BPDocument {

	private final BPContext _context;
	private final BPDocumentImplementation _impl;
	private BPNode _parent;
	private Document _bindDoc;
	private BPElement _root;

	public BPDocumentImpl(BPContext context, BPDocumentImplementation impl) {
		this._context = context;
		this._impl = impl;
	}

	@Override
	public boolean appendChild(BPNode node) {
		if (this._root == null) {
			if (node instanceof BPElement) {
				this._root = (BPElement) node;
				return true;
			}
		}
		return false;
	}

	@Override
	public BPNode setParent(BPNode parent) {
		BPNode old = this._parent;
		this._parent = parent;
		return old;
	}

	@Override
	public BPNode getParent() {
		return this._parent;
	}

	@Override
	public BPDocument getOwnerDocument() {
		return null;
	}

	@Override
	public boolean bind(Node node) {
		if (this._bindDoc == null)
			if (node instanceof Document) {
				this._bindDoc = (Document) node;
				return true;
			}
		return false;
	}

	@Override
	public boolean bind(BPDocument doc) {
		return false;
	}

	@Override
	public boolean bind(BPType type) {
		return false;
	}

	@Override
	public BPContext getContext() {
		return this._context;
	}

	@Override
	public BPDocumentImplementation getImplementation() {
		return this._impl;
	}

	@Override
	public BPElement getRootElement() {
		return this._root;
	}

	@Override
	public BPElement createElement(String uri, String localName) {
		BPType type = this.getContext().getTypeRegistrar()
				.getType(uri, localName);
		if (type == null) {
			return null;
		}
		BPElement ctrl = type.createController(this);
		return ctrl;
	}

	@Override
	public BPText createText(String data) {
		return new BPTextImpl(data);
	}

	@Override
	public BPType getType() {
		return null;
	}

	@Override
	public Node getDOMNode() {
		return this._bindDoc;
	}

}
