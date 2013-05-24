package ananas.lib.blueprint3.awt.swing;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BoxLayout;

import ananas.lib.blueprint3.awt.CComponent;
import ananas.lib.blueprint3.awt.CContainer;
import ananas.lib.blueprint3.awt.helper.Ctrl_AWTObject;
import ananas.lib.blueprint3.awt.helper.ILayoutManager;
import ananas.lib.blueprint3.dom.BPAttribute;

public class CBoxLayout extends Ctrl_AWTObject implements ILayoutManager {

	private boolean mIsInit;
	private int m_attr_axis = BoxLayout.Y_AXIS;

	@Override
	public void addComponentToContainer(CContainer cont, CComponent comp,
			String pos) {

		Container tCont = cont.getTargetContainer();
		Component tComp = comp.target_component();
		this.initIfNot(tCont);
		tCont.add(tComp);
	}

	private void initIfNot(Container tCont) {
		if (!this.mIsInit) {
			this.mIsInit = true;
			int dir = this.m_attr_axis;
			tCont.setLayout(new BoxLayout(tCont, dir));
		}
	}

	public boolean set_attribute_axis(BPAttribute attr) {
		String val = attr.getValue();
		if (val == null) {
			return false;
		} else if ("X_AXIS".equals(val)) {
			this.m_attr_axis = BoxLayout.X_AXIS;
		} else if ("Y_AXIS".equals(val)) {
			this.m_attr_axis = BoxLayout.Y_AXIS;
		} else if ("LINE_AXIS".equals(val)) {
			this.m_attr_axis = BoxLayout.LINE_AXIS;
		} else if ("PAGE_AXIS".equals(val)) {
			this.m_attr_axis = BoxLayout.PAGE_AXIS;
		} else {
			return false;
		}
		return true;
	}
}
