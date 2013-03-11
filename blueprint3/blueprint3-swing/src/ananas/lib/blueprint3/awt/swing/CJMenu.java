package ananas.lib.blueprint3.awt.swing;

import javax.swing.JMenu;

public class CJMenu extends CJMenuItem {

	public JMenu target_JMenu() {
		return (JMenu) this.getTarget(true);
	}

	public void onTagEnd() {
		super.onTagEnd();
	}

}
