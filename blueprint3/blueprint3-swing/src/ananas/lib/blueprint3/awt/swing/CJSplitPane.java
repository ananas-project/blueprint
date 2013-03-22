package ananas.lib.blueprint3.awt.swing;

import java.awt.Component;

import javax.swing.JSplitPane;

import ananas.lib.blueprint3.awt.CComponent;
import ananas.lib.blueprint3.awt.helper.Ctrl_pos;
import ananas.lib.blueprint3.awt.helper.ILayoutManager;
import ananas.lib.blueprint3.core.dom.BPAttribute;

public class CJSplitPane extends CJComponent {

	private BPAttribute m_attr_orientation;
	private BPAttribute m_attr_resizeWeight;

	public JSplitPane target_JSplitPane() {
		return (JSplitPane) this.getTarget(true);
	}

	public void onTagEnd() {
		super.onTagEnd();

		JSplitPane comp = this.target_JSplitPane();

		BPAttribute attr = this.m_attr_orientation;
		if (attr != null) {
			String val = attr.getValue();
			int nVal;
			if (val.equalsIgnoreCase("v") || val.equalsIgnoreCase("vert")
					|| val.equalsIgnoreCase("vertical")
					|| val.equalsIgnoreCase("vertical_split")) {
				this.target_JSplitPane().setOrientation(
						JSplitPane.VERTICAL_SPLIT);
				nVal = JSplitPane.VERTICAL_SPLIT;
			} else {
				nVal = JSplitPane.HORIZONTAL_SPLIT;
			}
			comp.setOrientation(nVal);
		}

		attr = this.m_attr_resizeWeight;
		if (attr != null) {
			comp.setResizeWeight(Double.parseDouble(attr.getValue()));
		}
	}

	public boolean set_attribute_orientation(BPAttribute attr) {
		this.m_attr_orientation = attr;
		return true;
	}

	public boolean set_attribute_resizeWeight(BPAttribute attr) {
		this.m_attr_resizeWeight = attr;
		return true;
	}

	@Override
	public boolean append_child_(CComponent comp) {
		Component child = comp.target_component();
		JSplitPane parent = this.target_JSplitPane();
		if (this._isBottom()) {
			parent.setRightComponent(child);
		} else {
			parent.setLeftComponent(child);
		}
		return true;
	}

	private boolean _isBottom() {
		if (this.mCurPos == null) {
		} else if ("right".equalsIgnoreCase(this.mCurPos)) {
			return true;
		} else if ("east".equalsIgnoreCase(this.mCurPos)) {
			return true;
		} else if ("bottom".equalsIgnoreCase(this.mCurPos)) {
			return true;
		} else if ("south".equalsIgnoreCase(this.mCurPos)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean append_child_(ILayoutManager mgr) {
		return false;
		// return super.append_child_(mgr);
	}

	private String mCurPos;

	@Override
	public boolean append_child_pos(Ctrl_pos pos) {
		this.mCurPos = pos.target_pos().getValue();
		return true;
		// return super.append_child_pos(pos);
	}

}
