package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_element extends XSTCtrl_annotated {

	private BPAttribute m_attr_name;
	private BPAttribute m_attr_minOccurs;
	private BPAttribute m_attr_maxOccurs;
	private BPAttribute m_attr_type;
	private BPAttribute m_attr_abstract;
	private BPAttribute m_attr_substitutionGroup;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("abstract")) {
			this.m_attr_abstract = attr;

		} else if (lname.equals("name")) {
			this.m_attr_name = attr;

		} else if (lname.equals("minOccurs")) {
			this.m_attr_minOccurs = attr;

		} else if (lname.equals("maxOccurs")) {
			this.m_attr_maxOccurs = attr;

		} else if (lname.equals("substitutionGroup")) {
			this.m_attr_substitutionGroup = attr;

		} else if (lname.equals("type")) {
			this.m_attr_type = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
