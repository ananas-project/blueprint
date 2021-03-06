package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_restrictionType extends XSTCtrl_annotated {

	private BPAttribute m_attr_base;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("base")) {
			this.m_attr_base = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
