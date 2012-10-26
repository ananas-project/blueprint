package ananas.lib.blueprint2;

import java.util.List;

import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.IDocument;
import ananas.lib.blueprint2.dom.IElement;
import ananas.lib.blueprint2.dom.INode;
import ananas.lib.blueprint2.dom.helper.IClass;
import ananas.lib.blueprint2.dom.helper.IInvokeable;

public class AbstractElement extends AbstractNode implements IElement {

	private IDocument mOwnerDoc;
	private IElement mParent;
	private Object mTarget;
	private String mId;
	private boolean mIsTagBegin;
	private boolean mIsTagEnd;

	protected AbstractElement() {
	}

	@Override
	public String getId() {
		return this.mId;
	}

	@Override
	public Object getTarget() {
		return this.mTarget;
	}

	@Override
	public Object createTarget() {
		IClass cls = this.getBlueprintClass();
		Class<?> tc = cls.getTargetClass();
		try {
			return tc.newInstance();
		} catch (Exception e) {
			throw new BlueprintException(e);
		}
	}

	@Override
	public IDocument getOwnerDocument() {
		return this.mOwnerDoc;
	}

	@Override
	public boolean bindTarget(Object target) {
		if (this.mTarget == null && target != null) {
			this.mTarget = target;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public final boolean bindOwnerDocument(IDocument ownerDoc) {
		if (this.mOwnerDoc == null && ownerDoc != null) {
			this.mOwnerDoc = ownerDoc;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean setAttribute(IAttr attr) {
		String lname = attr.getBlueprintClass().getLocalName();
		if ("id".equalsIgnoreCase(lname)) {
			this.mId = attr.getValue();
			return true;
		}
		return false;
	}

	@Override
	public final void tagBegin() {
		this.onTagBegin();
		if (!this.mIsTagBegin) {
			System.err
					.println("warning: the onTagBegin() has not been called : "
							+ this);
		}
	}

	@Override
	public final void tagEnd() {
		this.onTagEnd();
		if (!this.mIsTagEnd) {
			System.err.println("warning: the onTagEnd() has not been called : "
					+ this);
		}
	}

	protected void onTagBegin() {
		this.mIsTagBegin = true;
		if (this.mId != null) {
			this.mOwnerDoc.registerElement(this);
		}
	}

	protected void onTagEnd() {
		this.mIsTagEnd = true;
	}

	protected void onInvokeReturn(Object ret) {
	}

	@Override
	public IElement getParent() {
		return this.mParent;
	}

	@Override
	public List<IAttr> listAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final IElement setParent(IElement parent) {
		IElement old = this.mParent;
		this.mParent = parent;
		return old;
	}

	@Override
	public boolean appendChild(INode child) {
		if (child == null) {
			return false;
		} else if (child instanceof IInvokeable) {
			IInvokeable iv = (IInvokeable) child;
			Object rlt = iv.play((IElement) this);
			this.onInvokeReturn(rlt);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<INode> listChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTarget(boolean create) {
		Object t = this.mTarget;
		if (t == null && create) {
			this.mTarget = t = this.createTarget();
		}
		return t;
	}

}
