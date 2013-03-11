package ananas.lib.blueprint3.awt.swing;

import javax.swing.JMenuItem;

public class CJMenuItem extends CAbstractButton {

	public JMenuItem target_JMenuItem() {
		return (JMenuItem) this.getTarget(true);
	}

	public void onTagEnd() {
		super.onTagEnd();
	}

}
