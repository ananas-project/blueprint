package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_importType extends XSTCtrl_annotated {

	private BPAttribute m_attr_namespace;
	private BPAttribute m_attr_schemaLocation;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("namespace")) {
			this.m_attr_namespace = attr;

		} else if (lname.equals("schemaLocation")) {
			this.m_attr_schemaLocation = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
