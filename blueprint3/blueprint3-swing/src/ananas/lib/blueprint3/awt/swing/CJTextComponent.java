package ananas.lib.blueprint3.awt.swing;

import javax.swing.text.JTextComponent;

import ananas.lib.blueprint3.core.dom.BPAttribute;

public class CJTextComponent extends CJComponent {

	private BPAttribute m_attr_text;
	private BPAttribute m_attr_editable;

	public JTextComponent target_JTextComponent() {
		return (JTextComponent) this.getTarget(true);
	}

	public boolean set_attribute_text(BPAttribute attr) {
		this.m_attr_text = attr;
		return true;
	}

	public boolean set_attribute_editable(BPAttribute attr) {
		this.m_attr_editable = attr;
		return true;
	}

	public void onTagEnd() {
		super.onTagEnd();
		JTextComponent comp = this.target_JTextComponent();
		if (this.m_attr_text != null) {
			comp.setText(this.m_attr_text.getValue());
		}

		if (this.m_attr_editable != null) {
			boolean b;
			String val = this.m_attr_editable.getValue();
			if (val.equalsIgnoreCase("yes") || val.equalsIgnoreCase("true")
					|| val.equalsIgnoreCase("1")) {
				b = true;
			} else {
				b = false;
			}
			comp.setEditable(b);
		}
	}

}
