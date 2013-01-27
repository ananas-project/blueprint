package ananas.lib.blueprint.core.dom;

import ananas.lib.blueprint.core.lang.BPType;

public class AbstractNode implements BPNode {

	private BPDocument mOwnerDoc;
	private BPType mBpClass;
	private BPNode mParent;
	private Object mTarget;

	@Override
	public BPType getType() {
		return this.mBpClass;
	}

	@Override
	public Object getTarget() {
		return this.mTarget;
	}

	@Override
	public Object getTarget(boolean create) {
		Object inst = this.mTarget;
		if (inst == null) {
			this.mTarget = inst = this.createTarget();
		}
		return inst;
	}

	@Override
	public Object createTarget() {
		try {
			BPType bpcls = this.getType();
			Class<?> cls = bpcls.getTargetClass();
			Object inst = cls.newInstance();
			return inst;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean bindTarget(Object target) {
		if ((this.mTarget == null) && (target != null)) {
			this.mTarget = target;
			return true;
		}
		return false;
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
		BPNode oldParent;
		synchronized (this) {
			oldParent = this.mParent;
			this.mParent = newParent;
		}
		if (oldParent != null) {
			oldParent.removeChild(this);
		}
		if (newParent != null) {
		}
	}

	@Override
	public BPNode getParent() {
		return this.mParent;
	}

	@Override
	public boolean bindType(BPType bpClass) {
		if ((this.mBpClass == null) && (bpClass != null)) {
			this.mBpClass = bpClass;
			return true;
		}
		return false;
	}

	@Override
	public BPDocument getOwnerDocument() {
		return this.mOwnerDoc;
	}

	@Override
	public boolean bindOwnerDocument(BPDocument ownerDoc) {
		if ((this.mOwnerDoc == null) && (ownerDoc != null)) {
			this.mOwnerDoc = ownerDoc;
			return true;
		}
		return false;
	}

}
