package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPNode;

public class XSTCtrl_extensionType extends XSTCtrl_annotated {

	private BPAttribute m_attr_base;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("base")) {
			this.m_attr_base = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	public boolean appendChild(BPNode node) {

		String lname = node.getType().getLocalName();

		if (lname == null) {
			return false;

		} else if (lname.equals("attribute")) {
			XSTCtrl_attribute attr = (XSTCtrl_attribute) node;
			this._addAttribute(attr);

		} else if (lname.equals("choice")) {
			XSTCtrl_explicitGroup choice = (XSTCtrl_explicitGroup) node;
			this._setChoice(choice);

		} else if (lname.equals("sequence")) {
			XSTCtrl_explicitGroup sequence = (XSTCtrl_explicitGroup) node;
			this._setSequence(sequence);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _setChoice(XSTCtrl_explicitGroup choice) {
		// TODO Auto-generated method stub

	}

	private void _addAttribute(XSTCtrl_attribute attr) {
		// TODO Auto-generated method stub

	}

	private void _setSequence(XSTCtrl_explicitGroup sequence) {
		// TODO Auto-generated method stub

	}

}
