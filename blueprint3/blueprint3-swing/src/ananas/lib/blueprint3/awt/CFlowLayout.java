package ananas.lib.blueprint3.awt;

import java.awt.Component;
import java.awt.Container;

import ananas.lib.blueprint3.awt.helper.Ctrl_AWTObject;
import ananas.lib.blueprint3.awt.helper.ILayoutManager;

public class CFlowLayout extends Ctrl_AWTObject implements ILayoutManager {

	@Override
	public void addComponentToContainer(CContainer cont, CComponent comp,
			String pos) {

		Container tCont = cont.getTargetContainer();
		Component tComp = comp.target_component();
		tCont.add(tComp);
	}

}
