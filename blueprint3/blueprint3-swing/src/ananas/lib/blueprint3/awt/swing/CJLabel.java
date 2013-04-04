package ananas.lib.blueprint3.awt.swing;

import javax.swing.JLabel;

import ananas.lib.blueprint3.dom.BPAttribute;

public class CJLabel extends CJComponent {

	private BPAttribute m_attr_text;

	public boolean set_attribute_text(BPAttribute attr) {
		this.m_attr_text = attr;
		return true;
	}

	public void onTagEnd() {
		super.onTagEnd();
		JLabel label = (JLabel) this.getTarget(true);
		if (this.m_attr_text != null) {
			label.setText(this.m_attr_text.getValue());
		}
	}

}
