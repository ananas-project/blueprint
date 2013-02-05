package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPElement;

public class Element_class_ctrl extends Type_namedableObject_ctrl {

	public boolean appendElement(BPElement element) {
		String lname = element.getType().getLocalName();
		if (lname == null) {
			return false;

		} else if (lname.equals("attribute")) {
			// this._addAttribute((Element_attribute_ctrl) element);

		} else {
			return super.appendElement(element);
		}
		return true;
	}

}
