package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_notationType extends XSTCtrl_annotated {

	private BPAttribute m_attr_name;
	private BPAttribute m_attr_public;
	private BPAttribute m_attr_system;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		final String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("name")) {
			this.m_attr_name = attr;

		} else if (lname.equals("public")) {
			this.m_attr_public = attr;

		} else if (lname.equals("system")) {
			this.m_attr_system = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
