package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_topLevelElement extends XSTCtrl_element {

	private BPAttribute m_attr_ref;
	private BPAttribute m_attr_minOccurs;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("minOccurs")) {
			this.m_attr_minOccurs = attr;

		} else if (lname.equals("ref")) {
			this.m_attr_ref = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
