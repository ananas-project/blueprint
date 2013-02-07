package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.loader.eom.target.Tar_element;

public class Ctrl_element extends CtrlObject implements ICtrl_element {

	@Override
	public Tar_element getTarget_element() {
		return (Tar_element) this.getTarget(true);
	}

	@Override
	public boolean set_attribute_type(BPAttribute attr) {
		this.getTarget_element().setType(attr.getValue());
		return true;
	}

	@Override
	public boolean set_attribute_name(BPAttribute attr) {
		this.getTarget_element().setName(attr.getValue());
		return true;
	}

}
