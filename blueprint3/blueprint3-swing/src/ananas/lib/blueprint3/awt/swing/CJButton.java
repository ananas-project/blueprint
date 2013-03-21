package ananas.lib.blueprint3.awt.swing;

import javax.swing.JButton;

public class CJButton extends CAbstractButton {

	public JButton target_JButton() {
		return (JButton) this.getTarget(true);
	}

	public void onTagEnd() {
		super.onTagEnd();
	}

}
