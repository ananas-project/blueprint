package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPElement;

public class Element_namespace_ctrl extends Type_namedableObject_ctrl {

	public boolean appendElement(BPElement element) {
		String lname = element.getType().getLocalName();
		if (lname == null) {
			return false;

		} else if (lname.equals("property")) {
			this._addProperty((Element_property_ctrl) element);

		} else if (lname.equals("class")) {
			this._addClass((Element_class_ctrl) element);

		} else if (lname.equals("element")) {
			this._addElement((Element_element_ctrl) element);

		} else {
			return super.appendElement(element);
		}
		return true;
	}

	private void _addElement(Element_element_ctrl element) {
		// TODO Auto-generated method stub

	}

	private void _addClass(Element_class_ctrl element) {
		// TODO Auto-generated method stub

	}

	private void _addProperty(Element_property_ctrl element) {
		// TODO Auto-generated method stub

	}

}
