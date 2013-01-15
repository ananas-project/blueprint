package ananas.lib.blueprint2.awt;

import java.awt.Dialog;

import ananas.lib.blueprint2.dom.IAttr;

public class DialogWrapper extends WindowWrapper {

	private IAttr m_attr_title;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;

		} else if (name.equals("title")) {
			this.m_attr_title = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	@Override
	protected void onTagBegin() {

		super.onTagBegin();

		final Dialog comp = (Dialog) this.getTarget(true);

		if (this.m_attr_title != null) {
			String title = this.m_attr_title.getValue();
			comp.setTitle(title);
		}

	}

}
