package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_documentationType extends XSCElement {

	private BPAttribute m_attr_source;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("source")) {
			this.m_attr_source = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
