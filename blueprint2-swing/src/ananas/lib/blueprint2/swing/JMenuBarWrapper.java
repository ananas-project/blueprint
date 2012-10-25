package ananas.lib.blueprint2.swing;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ananas.lib.blueprint2.dom.IAttr;

public class JMenuBarWrapper extends JComponentWrapper {

	private IAttr mAttrActionListener;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name.equals("actionListener")) {
			this.mAttrActionListener = attr;
			return true;
		} else {
			return super.setAttribute(attr);
		}
	}

	public void onTagEnd() {
		super.onTagEnd();
		if (this.mAttrActionListener != null) {
			String uri = this.mAttrActionListener.getValue();
			ActionListener listener = (ActionListener) this.getOwnerDocument()
					.findTargetByURI(uri);
			this._listenMenuTree(listener);
		}
	}

	private void _listenMenuTree(ActionListener listener) {
		JMenuBar menubar = (JMenuBar) this.getTarget(true);
		int cnt = menubar.getMenuCount();
		for (int i = 0; i < cnt; i++) {
			JMenu menu = menubar.getMenu(i);
			this._listenMenuTree(listener, menu);
		}
	}

	private void _listenMenuTree(ActionListener listener, JMenu menu) {
		int cnt = menu.getItemCount();
		for (int i = cnt - 1; i >= 0; i--) {
			JMenuItem item = menu.getItem(i);
			if (item instanceof JMenu) {
				JMenu menu2 = (JMenu) item;
				this._listenMenuTree(listener, menu2);
			} else {
				item.addActionListener(listener);
			}
		}
	}
}
