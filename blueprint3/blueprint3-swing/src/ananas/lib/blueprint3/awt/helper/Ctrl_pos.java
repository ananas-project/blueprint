package ananas.lib.blueprint3.awt.helper;

import ananas.lib.blueprint3.core.dom.BPAttribute;
import ananas.lib.blueprint3.core.lang.CObject;

public class Ctrl_pos extends CObject {

	private String mValue;

	 
	public boolean set_attribute_value(BPAttribute attr) {
		this.mValue = attr.getValue();
		return true;
	}

	 
	public String getValue() {
		return this.mValue;
	}

}
