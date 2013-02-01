package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPNode;

public class XSTCtrl_group extends XSTCtrl_annotated {

	private BPAttribute m_attr_maxOccurs;
	private BPAttribute m_attr_minOccurs;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("minOccurs")) {
			this.m_attr_minOccurs = attr;

		} else if (lname.equals("maxOccurs")) {
			this.m_attr_maxOccurs = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	public boolean appendChild(BPNode node) {
		if (node == null) {
			return false;

		} else if (node instanceof XSTCtrl_element) {
			XSTCtrl_element element = (XSTCtrl_element) node;
			this._addElement(element);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _addElement(XSTCtrl_element element) {
		// TODO Auto-generated method stub

	}

}
