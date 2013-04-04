package ananas.lib.blueprint3.awt.helper;

import ananas.lib.blueprint3.dom.BPAttribute;
import ananas.lib.blueprint3.dom.BPElementMap;
import ananas.lib.blueprint3.lang.CObject;

public class Ctrl_AWTObject extends CObject {

	private String mId;

	public boolean set_attribute_id(BPAttribute id) {
		this.mId = id.getValue();
		return true;
	}

	public String getId() {
		return this.mId;
	}

	@Override
	public void onTagBegin() {

		super.onTagBegin();

		String id = this.mId;
		if (id != null) {
			BPElementMap reg = this.getOwnerDocument().getElementRegistrar();
			reg.put(id, this);
		}
	}

}
