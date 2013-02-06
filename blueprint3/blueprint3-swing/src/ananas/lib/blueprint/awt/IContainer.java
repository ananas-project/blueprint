package ananas.lib.blueprint.awt;

import java.awt.Container;

public interface IContainer {

	// attr

	// child

	boolean append_child_(CComponent comp);

	boolean append_child_(ILayoutManager mgr);

	boolean append_child_pos(Ctrl_pos pos);

	// other

	Container getTargetContainer();

}
