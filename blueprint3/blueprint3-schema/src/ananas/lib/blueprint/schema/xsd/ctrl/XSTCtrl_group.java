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

		String lname = node.getType().getLocalName();

		if (lname == null) {
			return false;

		} else if (lname.equals("choice")) {
			XSTCtrl_explicitGroup choice = (XSTCtrl_explicitGroup) node;
			this._addChoice(choice);

		} else if (lname.equals("element")) {
			XSTCtrl_element element = (XSTCtrl_element) node;
			this._addElement(element);

		} else if (lname.equals("sequence")) {
			XSTCtrl_explicitGroup sequence = (XSTCtrl_explicitGroup) node;
			this._addSequence(sequence);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _addSequence(XSTCtrl_explicitGroup sequence) {
		// TODO Auto-generated method stub

	}

	private void _addChoice(XSTCtrl_explicitGroup choice) {
		// TODO Auto-generated method stub

	}

	private void _addElement(XSTCtrl_element element) {
		// TODO Auto-generated method stub

	}

}
