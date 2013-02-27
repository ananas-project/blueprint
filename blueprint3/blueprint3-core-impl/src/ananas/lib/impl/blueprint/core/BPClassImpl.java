package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.dom.BPNode;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

public class BPClassImpl implements BPType {

	private final Class<?> mTargetClass;
	private final Class<?> mCtrlClass;
	private final BPNamespace mNS;
	private final String mLocalName;

	public BPClassImpl(BPNamespace ns, String localName, Class<?> ctrlClass,
			Class<?> targetClass) {

		this.mTargetClass = targetClass;
		this.mCtrlClass = ctrlClass;
		this.mNS = ns;
		this.mLocalName = localName;
	}

	@Override
	public Class<?> getTargetClass() {
		return this.mTargetClass;
	}

	@Override
	public Class<?> getControllerClass() {
		return this.mCtrlClass;
	}

	@Override
	public String getLocalName() {
		return this.mLocalName;
	}

	@Override
	public BPNamespace getOwnerNamespace() {
		return this.mNS;
	}

	@Override
	public boolean appendChildToParent(BPElement parent, BPNode child) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAttributeForParent(BPElement parent, BPAttribute attr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BPElement createElement(BPDocument doc) {
		throw new RuntimeException("no impl");
	}

}
