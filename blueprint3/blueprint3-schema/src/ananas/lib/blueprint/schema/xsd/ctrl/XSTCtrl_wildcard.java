package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class XSTCtrl_wildcard extends XSTCtrl_annotated {

	private BPAttribute m_attr_processContents;
	private BPAttribute m_attr_namespace;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		final String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("namespace")) {
			this.m_attr_namespace = attr;

		} else if (lname.equals("processContents")) {
			this.m_attr_processContents = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

}
