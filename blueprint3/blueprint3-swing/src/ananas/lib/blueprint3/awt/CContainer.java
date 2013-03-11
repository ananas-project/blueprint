package ananas.lib.blueprint3.awt;

import java.awt.Component;
import java.awt.Container;

import ananas.lib.blueprint3.awt.helper.Ctrl_pos;
import ananas.lib.blueprint3.awt.helper.ILayoutManager;

public class CContainer extends CComponent {

	private ILayoutManager mLayoutMgr;
	private Ctrl_pos mCurPos;

	public boolean append_child_(CComponent comp) {

		ILayoutManager mgr = this.mLayoutMgr;
		String pos = (this.mCurPos == null) ? null : this.mCurPos.target_pos()
				.getValue();

		if (mgr == null) {
			Container cont = this.getTargetContainer();
			Component ch = comp.target_component();
			cont.add(ch);
		} else {
			mgr.addComponentToContainer(this, comp, pos);
		}

		return true;
	}

	public Container getTargetContainer() {
		return (Container) this.getTarget(true);
	}

	public boolean append_child_(ILayoutManager mgr) {
		if (mgr != null) {
			this.mLayoutMgr = mgr;
			return true;
		}
		return false;
	}

	public boolean append_child_pos(Ctrl_pos pos) {
		this.mCurPos = pos;
		return true;
	}

}
