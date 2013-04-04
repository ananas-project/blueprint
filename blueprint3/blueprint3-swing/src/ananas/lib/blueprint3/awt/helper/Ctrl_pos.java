package ananas.lib.blueprint3.awt.helper;

import ananas.lib.blueprint3.dom.BPAttribute;

public class Ctrl_pos extends Ctrl_AWTObject {

	public boolean set_attribute_value(BPAttribute attr) {
		this.target_pos().setValue(attr.getValue());
		return true;
	}

	public Tar_pos target_pos() {
		return (Tar_pos) this.getTarget(true);
	}

}
