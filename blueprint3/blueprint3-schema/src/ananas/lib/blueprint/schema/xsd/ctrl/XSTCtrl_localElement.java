package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_localElement extends XSTCtrl_element {

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

			// } else if (lname.equals("type")) {
			// this.m_attr_type = attr;

		} else {
			return super.setAttribute(attr);
		}
		// return true;
	}

}
