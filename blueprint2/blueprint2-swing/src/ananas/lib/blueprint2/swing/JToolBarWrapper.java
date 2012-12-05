package ananas.lib.blueprint2.swing;

import javax.swing.JToolBar;

import ananas.lib.blueprint2.dom.IAttr;

public class JToolBarWrapper extends JComponentWrapper {

	private IAttr mFloatable;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;
		} else if (name.equals("floatable")) {
			this.mFloatable = attr;
		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	public void onTagEnd() {
		super.onTagEnd();

		JToolBar tb = (JToolBar) this.getTarget(true);

		if (this.mFloatable != null) {
			boolean b = this.booleanFromAttr(mFloatable);
			tb.setFloatable(b);
		}
	}

}
