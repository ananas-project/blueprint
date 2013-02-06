package ananas.lib.blueprint.loader.reflect.dom;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.dom.BPNode;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

public class MyElementType implements BPType {

	public static class Config {

		public Class<?> targetClass;
		public Class<?> ctrlClass;
		public BPNamespace ownerNS;
		public String localName;
	}

	private final Config mConf;

	public MyElementType(Config conf) {
		this.mConf = conf;
	}

	@Override
	public Class<?> getTargetClass() {
		return this.mConf.targetClass;
	}

	@Override
	public Class<?> getControllerClass() {
		return this.mConf.ctrlClass;
	}

	@Override
	public String getLocalName() {
		return this.mConf.localName;
	}

	@Override
	public BPNamespace getOwnerNamespace() {
		return this.mConf.ownerNS;
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
