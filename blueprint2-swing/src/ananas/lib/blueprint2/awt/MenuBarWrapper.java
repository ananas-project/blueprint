package ananas.lib.blueprint2.awt;

import java.awt.Menu;
import java.awt.MenuBar;

import ananas.lib.blueprint2.dom.INode;

public class MenuBarWrapper extends MenuComponentWrapper {

	@Override
	public boolean onAppendChild(INode child) {

		if (child instanceof MenuWrapper) {
			Menu menu = (Menu) ((MenuWrapper) child).getTarget(true);
			MenuBar menubar = (MenuBar) this.getTarget(true);
			menubar.add(menu);

		} else {
			return super.onAppendChild(child);
		}
		return true;
	}

}
