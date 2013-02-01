package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPNode;

public class XSTCtrl_complexContentType extends XSTCtrl_annotated {

	public boolean appendChild(BPNode node) {
		if (node == null) {
			return false;

		} else if (node instanceof XSTCtrl_restrictionType) {
			XSTCtrl_restrictionType rest = (XSTCtrl_restrictionType) node;
			this._setRestriction(rest);

		} else if (node instanceof XSTCtrl_extensionType) {
			XSTCtrl_extensionType ext = (XSTCtrl_extensionType) node;
			this._setExtension(ext);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _setExtension(XSTCtrl_extensionType ext) {
		// TODO Auto-generated method stub

	}

	private void _setRestriction(XSTCtrl_restrictionType rest) {
		// TODO Auto-generated method stub

	}

}
