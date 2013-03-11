package ananas.lib.blueprint3.awt;

import java.awt.Component;

import ananas.lib.blueprint3.awt.helper.Ctrl_AWTObject;
import ananas.lib.blueprint3.core.dom.BPAttribute;
import ananas.lib.blueprint3.core.util.attribute_helper.IntegerAttr;

public class CComponent extends Ctrl_AWTObject {

	private BPAttribute m_attr_x;
	private BPAttribute m_attr_y;
	private BPAttribute m_attr_width;
	private BPAttribute m_attr_height;

	public void onTagEnd() {
		super.onTagEnd();
		Component comp = (Component) this.getTarget(true);

		if (this.m_attr_x != null || this.m_attr_y != null) {
			int x = IntegerAttr.getInt(m_attr_x);
			int y = IntegerAttr.getInt(m_attr_y);
			comp.setLocation(x, y);
		}

		if (this.m_attr_width != null || this.m_attr_height != null) {
			int w = IntegerAttr.getInt(m_attr_width);
			int h = IntegerAttr.getInt(m_attr_height);
			comp.setSize(w, h);
		}
	}

	public Component target_component() {
		return (Component) this.getTarget(true);
	}

	public boolean set_attribute_x(BPAttribute attr) {
		this.m_attr_x = attr;
		return true;
	}

	public boolean set_attribute_y(BPAttribute attr) {
		this.m_attr_y = attr;
		return true;
	}

	public boolean set_attribute_width(BPAttribute attr) {
		this.m_attr_width = attr;
		return true;
	}

	public boolean set_attribute_height(BPAttribute attr) {
		this.m_attr_height = attr;
		return true;
	}

}
