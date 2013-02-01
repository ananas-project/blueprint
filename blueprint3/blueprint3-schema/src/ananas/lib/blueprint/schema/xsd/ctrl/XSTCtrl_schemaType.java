package ananas.lib.blueprint.schema.xsd.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPNode;

public class XSTCtrl_schemaType extends XSTCtrl_openAttrs {

	private BPAttribute m_attr_elementFormDefault;
	private BPAttribute m_attr_lang;
	private BPAttribute m_attr_targetNamespace;
	private BPAttribute m_attr_version;

	@Override
	public boolean setAttribute(BPAttribute attr) {

		String lname = attr.getType().getLocalName();
		if (lname == null) {
			return super.setAttribute(attr);

		} else if (lname.equals("elementFormDefault")) {
			this.m_attr_elementFormDefault = attr;

		} else if (lname.equals("lang")) {
			this.m_attr_lang = attr;

		} else if (lname.equals("targetNamespace")) {
			this.m_attr_targetNamespace = attr;

		} else if (lname.equals("version")) {
			this.m_attr_version = attr;

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

		} else if (node instanceof XSTCtrl_importType) {
			XSTCtrl_importType imp = (XSTCtrl_importType) node;
			this._addImport(imp);

		} else if (node instanceof XSTCtrl_topLevelElement) {
			XSTCtrl_topLevelElement element = (XSTCtrl_topLevelElement) node;
			this._addElement(element);

		} else if (node instanceof XSTCtrl_topLevelSimpleType) {
			XSTCtrl_topLevelSimpleType stype = (XSTCtrl_topLevelSimpleType) node;
			this._addSimpleType(stype);

		} else if (node instanceof XSTCtrl_topLevelComplexType) {
			XSTCtrl_topLevelComplexType ctype = (XSTCtrl_topLevelComplexType) node;
			this._addComplexType(ctype);

		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _addImport(XSTCtrl_importType imp) {
		// TODO Auto-generated method stub

	}

	private void _addComplexType(XSTCtrl_topLevelComplexType ctype) {
		// TODO Auto-generated method stub

	}

	private void _addSimpleType(XSTCtrl_topLevelSimpleType stype) {
		// TODO Auto-generated method stub

	}

	private void _addElement(XSTCtrl_topLevelElement element) {
		// TODO Auto-generated method stub

	}

	private void _setAnnotation(XSTCtrl_annotationType anotation) {
		// TODO Auto-generated method stub

	}

}
