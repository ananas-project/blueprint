package ananas.lib.blueprint2.awt;

import java.awt.Component;

import ananas.lib.blueprint2.dom.IAttr;

public class ComponentWrapper extends ObjectWrapper {

	private IAttr mX;
	private IAttr mY;
	private IAttr mWidth;
	private IAttr mHeight;
	private IAttr mName;
	private IAttr mFont;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;

		} else if (name.equals("id")) {
			this.mName = attr;
			return super.setAttribute(attr);

		} else if (name.equals("name")) {
			this.mName = attr;

		} else if (name.equals("x")) {
			this.mX = attr;
		} else if (name.equals("y")) {
			this.mY = attr;
		} else if (name.equals("height")) {
			this.mHeight = attr;
		} else if (name.equals("width")) {
			this.mWidth = attr;

		} else if (name.equals("font")) {
			this.mFont = attr;

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	@Override
	protected void onTagBegin() {
		super.onTagBegin();

		final Component comp = (Component) this.getTarget(true);

		if (this.mX != null || this.mY != null || this.mWidth != null
				|| this.mHeight != null) {
			int x = this.intFromAttr(this.mX);
			int y = this.intFromAttr(this.mY);
			int w = this.intFromAttr(this.mWidth);
			int h = this.intFromAttr(this.mHeight);
			comp.setBounds(x, y, w, h);
		}

		if (this.mName != null) {
			comp.setName(this.mName.getValue());
		}

		if (this.mFont != null) {
			comp.setFont(this.fontFromAttr(this.mFont));
		}
	}

	public Component getComponent(boolean create) {
		return (Component) this.getTarget(create);
	}

}
