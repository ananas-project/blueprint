package ananas.lib.impl.blueprint.core;

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
	public BPType getAttributeType(String uri, String localName) {
		if (uri == null) {
			uri = "";
		}
		BPNamespace ns;
		if (uri.isEmpty()) {
			ns = this.mNS;
		} else {
			ns = this.mNS.getOwnerEnvironment().getNamespaceRegistrar()
					.getNamespace(uri);
		}
		if (ns == null) {
			return null;
		} else {
			return ns.getType(localName);
		}
	}

	@Override
	public String getLocalName() {
		return this.mLocalName;
	}

	@Override
	public BPNamespace getOwnerNamespace() {
		return this.mNS;
	}

}
