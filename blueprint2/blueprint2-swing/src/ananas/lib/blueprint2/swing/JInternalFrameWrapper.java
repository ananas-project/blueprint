package ananas.lib.blueprint2.swing;

import javax.swing.JInternalFrame;

import ananas.lib.blueprint2.dom.IAttr;

public class JInternalFrameWrapper extends JComponentWrapper {

	private IAttr mTitle;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;
		} else if (name.equals("title")) {
			this.mTitle = attr;
		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	@Override
	public void onTagEnd() {

		super.onTagEnd();

		JInternalFrame frame = (JInternalFrame) this.getTarget(true);
		if (this.mTitle != null) {
			String s = this.stringFromAttr(this.mTitle);
			frame.setTitle(s);
		}
	}
}
