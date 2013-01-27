package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_fieldType extends XSTCtrl_annotated {

	private BPAttribute m_attr_xpath;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("xpath")) {
			this.m_attr_xpath = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
