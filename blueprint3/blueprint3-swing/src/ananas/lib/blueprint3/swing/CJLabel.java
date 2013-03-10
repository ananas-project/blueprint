package ananas.lib.blueprint3.swing;

import javax.swing.JLabel;

import ananas.lib.blueprint3.core.dom.BPAttribute;

public class CJLabel extends CJComponent implements IJLable {

	private BPAttribute m_attr_text;

	@Override
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
