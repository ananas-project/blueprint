package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPNode;

public class XSTCtrl_annotationType extends XSTCtrl_openAttrs {

	public boolean appendChild(BPNode node) {

		if (node == null) {
			return false;

		} else if (node instanceof XSTCtrl_documentationType) {
			XSTCtrl_documentationType documentation = (XSTCtrl_documentationType) node;
			this._addDocumentation(documentation);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _addDocumentation(XSTCtrl_documentationType documentation) {
		// TODO Auto-generated method stub

	}

}
