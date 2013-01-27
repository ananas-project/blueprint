package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_group extends XSTCtrl_annotated {

	private BPAttribute m_attr_maxOccurs;
	private BPAttribute m_attr_minOccurs;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("minOccurs")) {
			this.m_attr_minOccurs = attr;

		} else if (lname.equals("maxOccurs")) {
			this.m_attr_maxOccurs = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
