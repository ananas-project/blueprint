package ananas.lib.blueprint2.swing;

import javax.swing.JScrollBar;

import ananas.lib.blueprint2.dom.IAttr;

public class JScrollBarWrapper extends JComponentWrapper {

	private String m_attr_orientation;

	public JScrollBar getJScrollBar() {
		return (JScrollBar) this.getTarget(true);
	}

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if ("orientation".equals(name)) {
			this.m_attr_orientation = attr.getValue();
			return true;
		} else {
			return super.setAttribute(attr);
		}
	}

	@Override
	protected void onTagBegin() {
		super.onTagBegin();

		String orien = this.m_attr_orientation;
		if (orien != null) {
			int nOrien = (orien.equalsIgnoreCase("VERTICAL")) ? JScrollBar.VERTICAL
					: JScrollBar.HORIZONTAL;
			this.getJScrollBar().setOrientation(nOrien);
		}
	}

}
