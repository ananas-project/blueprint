package ananas.lib.blueprint.loader.eom.ctrl;

import ananas.lib.blueprint.loader.eom.target.Tar_eom;

public interface ICtrl_eom {

	boolean append_child_namespace(Ctrl_namespace ns);

	// other

	Tar_eom getTarget_eom();

}
