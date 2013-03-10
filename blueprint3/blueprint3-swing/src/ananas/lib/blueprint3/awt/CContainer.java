package ananas.lib.blueprint3.awt;

import java.awt.Component;
import java.awt.Container;

public class CContainer extends CComponent implements IContainer {

	private ILayoutManager mLayoutMgr;
	private Ctrl_pos mCurPos;

	@Override
	public boolean append_child_(CComponent comp) {

		ILayoutManager mgr = this.mLayoutMgr;
		String pos = (this.mCurPos == null) ? null : this.mCurPos.getValue();

		if (mgr == null) {
			Container cont = this.getTargetContainer();
			Component ch = comp.getTargetComponent();
			cont.add(ch);
		} else {
			mgr.addComponentToContainer(this, comp, pos);
		}

		return true;
	}

	@Override
	public Container getTargetContainer() {
		return (Container) this.getTarget(true);
	}

	@Override
	public boolean append_child_(ILayoutManager mgr) {
		if (mgr != null) {
			this.mLayoutMgr = mgr;
			return true;
		}
		return false;
	}

	@Override
	public boolean append_child_pos(Ctrl_pos pos) {
		this.mCurPos = pos;
		return true;
	}

}
