package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.loader.eom.target.Tar_element;

public interface ICtrl_element {

	boolean set_attribute_type(BPAttribute attr);

	boolean set_attribute_name(BPAttribute attr);

	// other

	Tar_element getTarget_element();
}
