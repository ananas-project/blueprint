package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_topLevelAttribute extends XSTCtrl_attribute {

	private BPAttribute m_attr_name;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("name")) {
			this.m_attr_name = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}
}
