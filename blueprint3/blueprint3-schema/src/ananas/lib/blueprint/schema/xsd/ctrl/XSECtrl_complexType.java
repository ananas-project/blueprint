package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSECtrl_complexType extends XSTCtrl_topLevelComplexType {

	private BPAttribute m_attr_name;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getBPClass().getLocalName();
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
