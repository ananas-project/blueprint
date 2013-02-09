package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.loader.eom.target.Tar_namespace;

public interface ICtrl_namespace {

	// attribute

	boolean set_attribute_uri(BPAttribute attr);

	boolean set_attribute_enableExport(BPAttribute attr);

	// child

	boolean append_child_property(Ctrl_property prop);

	boolean append_child_class(Ctrl_class aClass);

	// other

	Tar_namespace getTarget_namespace();
}
