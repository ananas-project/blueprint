package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPElement;

public class Element_mapping_ctrl extends ElementObjectCtrl {

	public boolean appendElement(BPElement element) {
		String lname = element.getType().getLocalName();
		if (lname == null) {
			return false;

		} else if (lname.equals("namespace")) {
			this._addNamespace((Element_namespace_ctrl) element);

		} else {
			return super.appendElement(element);
		}
		return true;
	}

	private void _addNamespace(Element_namespace_ctrl element) {
		// TODO Auto-generated method stub

	}

}
