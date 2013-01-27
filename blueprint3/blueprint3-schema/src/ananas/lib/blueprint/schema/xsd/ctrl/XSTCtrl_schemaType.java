package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPNode;

public class XSTCtrl_schemaType extends XSTCtrl_openAttrs {

	public boolean appendChild(BPNode node) {

		if (node == null) {
			return false;

		} else if (node instanceof XSTCtrl_annotationType) {
			XSTCtrl_annotationType annotation = (XSTCtrl_annotationType) node;
			this._addAnnotation(annotation);

		} else if (node instanceof XSTCtrl_element) {
			XSTCtrl_element element = (XSTCtrl_element) node;
			this._addElement(element);

		} else if (node instanceof XSTCtrl_simpleType) {
			XSTCtrl_simpleType stype = (XSTCtrl_simpleType) node;
			this._addSimpleType(stype);

		} else if (node instanceof XSTCtrl_complexType) {
			XSTCtrl_complexType ctype = (XSTCtrl_complexType) node;
			this._addComplexType(ctype);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _addComplexType(XSTCtrl_complexType ctype) {
		// TODO Auto-generated method stub

	}

	private void _addSimpleType(XSTCtrl_simpleType stype) {
		// TODO Auto-generated method stub

	}

	private void _addElement(XSTCtrl_element element) {
		// TODO Auto-generated method stub

	}

	private void _addAnnotation(XSTCtrl_annotationType anotation) {
		// TODO Auto-generated method stub

	}

}
