package ananas.lib.blueprint3.awt;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import ananas.lib.blueprint3.awt.helper.Ctrl_AWTObject;
import ananas.lib.blueprint3.awt.helper.ILayoutManager;
import ananas.lib.blueprint3.dom.BPAttribute;

public class CGridLayout extends Ctrl_AWTObject implements ILayoutManager {

	private int m_attr_rows = 1;
	private int m_attr_cols = 1;
	private int m_attr_hgap = 0;
	private int m_attr_vgap = 0;
	private boolean mIsInit;

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
			// (int rows, int cols, int hgap, int vgap)
			GridLayout gl = new GridLayout(this.m_attr_rows, this.m_attr_cols,
					this.m_attr_hgap, this.m_attr_vgap);
			tCont.setLayout(gl);
		}
	}

	public boolean set_attribute_rows(BPAttribute attr) {
		this.m_attr_rows = Integer.parseInt(attr.getValue());
		return true;
	}

	public boolean set_attribute_cols(BPAttribute attr) {
		this.m_attr_cols = Integer.parseInt(attr.getValue());
		return true;
	}

	public boolean set_attribute_hgap(BPAttribute attr) {
		this.m_attr_hgap = Integer.parseInt(attr.getValue());
		return true;
	}

	public boolean set_attribute_vgap(BPAttribute attr) {
		this.m_attr_vgap = Integer.parseInt(attr.getValue());
		return true;
	}

}
