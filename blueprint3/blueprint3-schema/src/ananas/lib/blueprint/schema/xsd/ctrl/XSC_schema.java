package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSC_schema extends XSCElement {

	private BPAttribute m_attr_elementFormDefault;
	private BPAttribute m_attr_lang;
	private BPAttribute m_attr_targetNamespace;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getBPClass().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("elementFormDefault")) {
			this.m_attr_elementFormDefault = attr;

		} else if (lname.equals("lang")) {
			this.m_attr_lang = attr;

		} else if (lname.equals("targetNamespace")) {
			this.m_attr_targetNamespace = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
