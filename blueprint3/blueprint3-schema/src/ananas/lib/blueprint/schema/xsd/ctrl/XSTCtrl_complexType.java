package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPNode;

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

	public boolean appendChild(BPNode node) {
		if (node == null) {
			return false;

		} else if (node instanceof XSTCtrl_complexContentType) {
			XSTCtrl_complexContentType cct = (XSTCtrl_complexContentType) node;
			this._setComplexContent(cct);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _setComplexContent(XSTCtrl_complexContentType cct) {
		// TODO Auto-generated method stub

	}

}
