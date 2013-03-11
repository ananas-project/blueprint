package ananas.lib.blueprint3.awt;

import java.awt.Frame;

import ananas.lib.blueprint3.core.dom.BPAttribute;

public class CFrame extends CWindow {

	private BPAttribute m_attr_title;

	public Frame target_frame() {
		return (Frame) this.getTarget(true);
	}

	public boolean set_attribute_title(BPAttribute attr) {
		this.m_attr_title = attr;
		return true;
	}

	public void onTagEnd() {
		super.onTagEnd();

		BPAttribute attr = this.m_attr_title;
		if (attr != null) {
			this.target_frame().setTitle(attr.getValue());
		}
	}

}
