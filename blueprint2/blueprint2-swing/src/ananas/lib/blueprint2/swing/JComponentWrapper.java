package ananas.lib.blueprint2.swing;

import javax.swing.JComponent;
import javax.swing.border.Border;

import ananas.lib.blueprint2.awt.ContainerWrapper;
import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.INode;

public class JComponentWrapper extends ContainerWrapper {

	private String m_attr_alignmentX;
	private String m_attr_alignmentY;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;

		} else if (name.equals("alignmentX")) {
			this.m_attr_alignmentX = attr.getValue();

		} else if (name.equals("alignmentY")) {
			this.m_attr_alignmentY = attr.getValue();

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	protected void onTagBegin() {
		super.onTagBegin();
		JComponent comp = (JComponent) this.getTarget(true);

		if (this.m_attr_alignmentX != null) {
			comp.setAlignmentX(Float.parseFloat(this.m_attr_alignmentX));
		}
		if (this.m_attr_alignmentY != null) {
			comp.setAlignmentY(Float.parseFloat(this.m_attr_alignmentY));
		}
	}

	@Override
	public boolean onAppendChild(INode child) {
		if (child == null) {
			return false;

		} else if (child instanceof IBorderProvider) {
			this._setBorder((IBorderProvider) child);
			return true;

		} else {
			return super.onAppendChild(child);
		}
	}

	private void _setBorder(IBorderProvider ibp) {
		JComponent comp = this.getJComponent();
		Border border = ibp.getBorder();
		comp.setBorder(border);
	}

	private JComponent getJComponent() {
		return (JComponent) this.getTarget(true);
	}

}
