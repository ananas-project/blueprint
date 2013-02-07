package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.loader.eom.target.Tar_attribute;

public interface ICtrl_attribute {

	boolean set_attribute_name(BPAttribute attr);

	// other

	Tar_attribute getTarget_attribute();

}
