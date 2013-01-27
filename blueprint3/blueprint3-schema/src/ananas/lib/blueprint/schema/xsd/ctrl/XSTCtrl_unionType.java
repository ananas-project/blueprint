package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_unionType extends XSTCtrl_annotated {

	private BPAttribute m_attr_memberTypes;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("memberTypes")) {
			this.m_attr_memberTypes = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
