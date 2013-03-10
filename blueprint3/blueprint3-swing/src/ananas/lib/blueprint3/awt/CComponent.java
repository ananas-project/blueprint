package ananas.lib.blueprint3.awt;

import java.awt.Component;

import ananas.lib.blueprint3.core.dom.BPAttribute;
import ananas.lib.blueprint3.core.lang.CObject;
import ananas.lib.blueprint3.core.util.attribute_helper.IntegerAttr;

public class CComponent extends CObject implements IComponent {

	private BPAttribute m_attr_x;
	private BPAttribute m_attr_y;
	private BPAttribute m_attr_width;
	private BPAttribute m_attr_height;

	@Override
	public boolean set_attribute_x(BPAttribute attr) {
		this.m_attr_x = attr;
		return true;
	}

	@Override
	public boolean set_attribute_y(BPAttribute attr) {
		this.m_attr_y = attr;
		return true;
	}

	@Override
	public boolean set_attribute_height(BPAttribute attr) {
		this.m_attr_height = attr;
		return true;
	}

	@Override
	public boolean set_attribute_width(BPAttribute attr) {
		this.m_attr_width = attr;
		return true;
	}

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

	@Override
	public Component getTargetComponent() {
		return (Component) this.getTarget(true);
	}

	@Override
	public boolean set_attribute_test(BPAttribute attr) {
		// TODO Auto-generated method stub
		return false;
	}

}
