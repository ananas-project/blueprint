package impl.ananas.blueprint4.core.namespace;

import ananas.blueprint4.core.lang.BPNode;
import ananas.blueprint4.core.lang.BPText;

public class Ctr_property extends Ctr_object {

	public Tar_property target_property() {
		return (Tar_property) this.getTarget(true);
	}

	public boolean onAppendChild(BPNode child) {
		if (child == null) {
			return false;
		} else if (child instanceof BPText) {
			String s = ((BPText) child).getData();
			this.target_property().setValue(s);
		} else {
			return super.onAppendChild(child);
		}
		return true;
	}

	public boolean onSetAttribute(String uri, String localName, String value) {
		if (localName == null) {
			return false;
		} else if (localName.equals("key")) {
			this.target_property().setKey(value);
		} else {
			return super.onSetAttribute(uri, localName, value);
		}
		return true;
	}

}
