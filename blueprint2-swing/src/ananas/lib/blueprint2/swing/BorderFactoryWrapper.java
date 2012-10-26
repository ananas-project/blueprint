package ananas.lib.blueprint2.swing;

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

	@Override
	protected void onInvokeReturn(Object ret) {

		super.onInvokeReturn(ret);

		if (ret instanceof Border)
			this.mBorder = (Border) ret;

	}

}
