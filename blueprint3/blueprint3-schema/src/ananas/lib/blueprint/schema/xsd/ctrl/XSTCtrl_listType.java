package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_listType extends XSTCtrl_annotated {

	private BPAttribute m_attr_itemType;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("itemType")) {
			this.m_attr_itemType = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
