package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_attribute extends XSTCtrl_annotated {

	private BPAttribute m_attr_type;
	private BPAttribute m_attr_default;
	private BPAttribute m_attr_use;
	private BPAttribute m_attr_name;
	private BPAttribute m_attr_ref;
	private BPAttribute m_attr_fixed;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		final String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("default")) {
			this.m_attr_default = attr;

		} else if (lname.equals("fixed")) {
			this.m_attr_fixed = attr;

		} else if (lname.equals("name")) {
			this.m_attr_name = attr;

		} else if (lname.equals("ref")) {
			this.m_attr_ref = attr;

		} else if (lname.equals("type")) {
			this.m_attr_type = attr;

		} else if (lname.equals("use")) {
			this.m_attr_use = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
