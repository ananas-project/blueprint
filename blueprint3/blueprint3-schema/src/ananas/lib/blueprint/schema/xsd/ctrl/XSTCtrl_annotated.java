package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_annotated extends XSTCtrl_openAttrs {

	private BPAttribute m_attr_id;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("id")) {
			this.m_attr_id = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
