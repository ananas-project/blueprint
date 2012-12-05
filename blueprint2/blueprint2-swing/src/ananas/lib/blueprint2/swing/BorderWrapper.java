package ananas.lib.blueprint2.swing;

import javax.swing.border.Border;

import ananas.lib.blueprint2.awt.ObjectWrapper;

public class BorderWrapper extends ObjectWrapper  implements IBorderProvider {

	public Border getBorder() {
		return (Border) this.getTarget(true);
	}

	@Override
	public Object createTarget() {
		// TODO Auto-generated method stub
		return super.createTarget();
	}

}
