package ananas.lib.blueprint2.swing;

import javax.swing.AbstractButton;
import javax.swing.Icon;

import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.INode;

public class AbstractButtonWrapper extends JComponentWrapper {

	private IAttr mText;
	private IAttr mActionCommand;

	@Override
	public boolean setAttribute(IAttr attr) {
		String lname = attr.getBlueprintClass().getLocalName();
		if (lname == null) {
			return false;
		} else if (lname.equals("actionCommand")) {
			this.mActionCommand = attr;
		} else if (lname.equals("command")) {
			this.mActionCommand = attr;
		} else if (lname.equals("label")) {
			this.mText = attr;
		} else if (lname.equals("text")) {
			this.mText = attr;
		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	@Override
	public void onTagBegin() {
		super.onTagBegin();
		AbstractButton btn = (AbstractButton) this.getTarget(true);
		if (this.mText != null) {
			String s = this.stringFromAttr(this.mText);
			btn.setText(s);
		}

		if (this.mActionCommand != null) {
			String s = this.stringFromAttr(this.mActionCommand);
			btn.setActionCommand(s);
		}
	}

	@Override
	public boolean appendChild(INode child) {

		if (child == null) {
			return false;

		} else if (child instanceof IconWrapper) {
			Icon icon = ((IconWrapper) child).getIcon();
			AbstractButton btn = (AbstractButton) this.getTarget(true);
			btn.setIcon(icon);
			return true;

		} else {
			return super.appendChild(child);
		}
	}

}
