package ananas.lib.blueprint.loader.eom;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.dom.BPNode;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

public class MyBpType implements BPType {

	private final Class<?> mTargetClass;
	private final Class<?> mCtrlClass;
	private final String mLocalName;
	private final BPNamespace mOwnerNS;

	public MyBpType(BPNamespace ownerNS, String localName, Class<?> ctrlClass,
			Class<?> targetClass) {
		this.mOwnerNS = ownerNS;
		this.mLocalName = localName;
		this.mCtrlClass = ctrlClass;
		this.mTargetClass = targetClass;
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
		return this.mOwnerNS;
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

}
