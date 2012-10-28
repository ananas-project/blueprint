package ananas.lib.blueprint2.awt;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;

public interface LayoutManagerWrapper {

	LayoutManager getLayoutManager(boolean create);

	/**
	 * @return true if success , otherwise is false.
	 * */
	boolean setContainer(Container container);

	void addComponentToContainer(Component component, Container container,
			String position);

}
