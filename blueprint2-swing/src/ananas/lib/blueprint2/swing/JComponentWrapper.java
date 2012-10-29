package ananas.lib.blueprint2.swing;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.Border;

import ananas.lib.blueprint2.awt.ContainerWrapper;
import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.INode;

public class JComponentWrapper extends ContainerWrapper {

	private IAttr mBackground;
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

		} else if (name.equals("background")) {
			this.mBackground = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	protected void onTagBegin() {
		super.onTagBegin();
		JComponent comp = (JComponent) this.getTarget(true);
		if (this.mBackground != null) {
			Color color = this.colorFromAttr(this.mBackground);
			comp.setBackground(color);
		}

		if (this.m_attr_alignmentX != null) {
		}
		if (this.m_attr_alignmentY != null) {
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
