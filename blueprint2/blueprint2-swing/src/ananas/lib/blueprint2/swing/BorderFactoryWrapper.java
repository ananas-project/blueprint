package ananas.lib.blueprint2.swing;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import ananas.lib.blueprint2.awt.ObjectWrapper;

public class BorderFactoryWrapper extends ObjectWrapper implements
		IBorderProvider {

	private Border mBorder;

	public Border getBorder() {
		return this.mBorder;
	}

	@Override
	public Object createTarget() {
		return this.mBorder;
	}

	public void createTitledBorder(String title) {
		this.mBorder = BorderFactory.createTitledBorder(title);
	}

	public void createEmptyBorder(int top, int left, int bottom, int right) {
		this.mBorder = BorderFactory
				.createEmptyBorder(top, left, bottom, right);
	}

	public void createCompoundBorder(Border b1, Border b2) {
		this.mBorder = BorderFactory.createCompoundBorder(b1, b2);
	}

}
