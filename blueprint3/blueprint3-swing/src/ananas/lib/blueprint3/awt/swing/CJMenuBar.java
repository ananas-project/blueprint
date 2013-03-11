package ananas.lib.blueprint3.awt.swing;

import javax.swing.JMenuBar;

import ananas.lib.blueprint3.core.dom.BPAttribute;

public class CJMenuBar extends CJComponent {

	private BPAttribute m_attr_actionListener;

	public JMenuBar target_JMenuBar() {
		return (JMenuBar) this.getTarget(true);
	}

	public boolean set_attribute_actionListener(BPAttribute attr) {
		this.m_attr_actionListener = attr;
		return true;
	}

	public void onTagEnd() {
		super.onTagEnd();

		JMenuBar mb = this.target_JMenuBar();

		BPAttribute attr = this.m_attr_actionListener;
		if (attr != null) {
			// TODO add listener
		}
	}

}
