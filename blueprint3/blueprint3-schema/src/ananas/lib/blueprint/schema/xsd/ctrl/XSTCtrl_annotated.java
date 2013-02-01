package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPNode;

public class XSTCtrl_annotated extends XSTCtrl_openAttrs {

	private BPAttribute m_attr_id;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("id")) {
			this.m_attr_id = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	public boolean appendChild(BPNode node) {
		if (node == null) {
			return false;

		} else if (node instanceof XSTCtrl_annotationType) {
			XSTCtrl_annotationType annotation = (XSTCtrl_annotationType) node;
			this._setAnnotation(annotation);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _setAnnotation(XSTCtrl_annotationType annotation) {
		// TODO Auto-generated method stub

	}

}
