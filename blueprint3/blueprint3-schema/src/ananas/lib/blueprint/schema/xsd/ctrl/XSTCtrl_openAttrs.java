package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPNode;

public class XSTCtrl_openAttrs extends XSCElement {

	public boolean appendChild(BPNode node) {
		if (node == null) {
			return false;

		} else if (node instanceof XSTCtrl_anyAttributeType) {
			XSTCtrl_anyAttributeType anyAttr = (XSTCtrl_anyAttributeType) node;
			this._setAnyAttr(anyAttr);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _setAnyAttr(XSTCtrl_anyAttributeType anyAttr) {
		// TODO Auto-generated method stub

	}

}
