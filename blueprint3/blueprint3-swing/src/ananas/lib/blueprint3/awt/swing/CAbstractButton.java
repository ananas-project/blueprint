package ananas.lib.blueprint3.awt.swing;

import javax.swing.AbstractButton;

import ananas.lib.blueprint3.dom.BPAttribute;
import ananas.lib.util.logging.Logger;

public class CAbstractButton extends CJComponent {

	private final static Logger logger = Logger.Agent.getLogger();

	private BPAttribute m_attr_text;

	private BPAttribute m_attr_actionCommand;

	public AbstractButton target_AbstractButton() {
		return (AbstractButton) this.getTarget(true);
	}

	public boolean set_attribute_label(BPAttribute attr) {
		logger.warn("Deprecated. - Replaced by setText(text)");
		this.m_attr_text = attr;
		return true;
	}

	public boolean set_attribute_text(BPAttribute attr) {
		this.m_attr_text = attr;
		return true;
	}

	public boolean set_attribute_command(BPAttribute attr) {
		this.m_attr_actionCommand = attr;
		return true;
	}

	public boolean set_attribute_actionCommand(BPAttribute attr) {
		this.m_attr_actionCommand = attr;
		return true;
	}

	public void onTagEnd() {
		super.onTagEnd();

		AbstractButton ab = this.target_AbstractButton();

		// attr: text
		BPAttribute attr = this.m_attr_text;
		if (attr != null) {
			ab.setText(attr.getValue());
		}

		// attr: actionCommand
		attr = this.m_attr_actionCommand;
		if (attr != null) {
			ab.setActionCommand(attr.getValue());
		}
	}

}
