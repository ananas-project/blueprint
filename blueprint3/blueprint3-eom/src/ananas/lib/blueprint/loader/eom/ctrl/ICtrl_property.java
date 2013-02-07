package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.loader.eom.target.Tar_property;

public interface ICtrl_property {

	boolean set_attribute_key(BPAttribute attr);

	boolean set_attribute_value(BPAttribute attr);

	// other

	Tar_property getTarget_property();

}
