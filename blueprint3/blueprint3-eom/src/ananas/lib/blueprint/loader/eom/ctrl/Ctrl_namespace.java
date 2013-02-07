package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.loader.eom.target.Tar_namespace;

public class Ctrl_namespace extends CtrlObject implements ICtrl_namespace {

	@Override
	public boolean set_attribute_name(BPAttribute attr) {
		this.getTarget_namespace().setName(attr.getValue());
		return true;
	}

	@Override
	public Tar_namespace getTarget_namespace() {
		return (Tar_namespace) this.getTarget(true);
	}

	@Override
	public boolean append_child_property(Ctrl_property prop) {
		this.getTarget_namespace().setProperty(prop.getTarget_property());
		return true;
	}

	@Override
	public boolean append_child_class(Ctrl_class aClass) {
		this.getTarget_namespace().addClass(aClass.getTarget_class());
		return true;
	}

}
