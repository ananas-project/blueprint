package ananas.lib.blueprint3.awt.swing;

import javax.swing.JSplitPane;

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
}
