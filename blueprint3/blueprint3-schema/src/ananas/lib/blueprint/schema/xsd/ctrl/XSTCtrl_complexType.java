package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_complexType extends XSTCtrl_annotated {

	private BPAttribute m_attr_abstract;
	private BPAttribute m_attr_mixed;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("abstract")) {
			this.m_attr_abstract = attr;

		} else if (lname.equals("mixed")) {
			this.m_attr_mixed = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
