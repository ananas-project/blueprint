package ananas.lib.blueprint3.awt.swing;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import ananas.lib.blueprint3.awt.CComponent;
import ananas.lib.blueprint3.awt.CFrame;

public class CJFrame extends CFrame {

	public JFrame target_JFrame() {
		return (JFrame) this.getTarget(true);
	}

	@Override
	public boolean append_child_(CComponent comp) {
		if (comp instanceof CJMenuBar) {
			return this._setJMenuBar((CJMenuBar) comp);
		} else {
			return super.append_child_(comp);
		}
	}

	private boolean _setJMenuBar(CJMenuBar cjmb) {
		JMenuBar menubar = cjmb.target_JMenuBar();
		this.target_JFrame().setJMenuBar(menubar);
		return true;
	}

}
