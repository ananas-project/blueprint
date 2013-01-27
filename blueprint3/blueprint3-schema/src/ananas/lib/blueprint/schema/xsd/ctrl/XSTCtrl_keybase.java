package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_keybase extends XSTCtrl_annotated {

	private BPAttribute m_attr_name;
	private BPAttribute m_attr_ref;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("name")) {
			this.m_attr_name = attr;

		} else if (lname.equals("ref")) {
			this.m_attr_ref = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
