package ananas.lib.blueprint3.awt.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ananas.lib.blueprint3.dom.BPAttribute;

public class CJMenuBar extends CJComponent {

	private BPAttribute m_attr_actionListener;

	public JMenuBar target_JMenuBar() {
		return (JMenuBar) this.getTarget(true);
	}

	public boolean set_attribute_actionListener(BPAttribute attr) {
		this.m_attr_actionListener = attr;
		return true;
	}

	public void onTagEnd() {
		super.onTagEnd();
		this._setListeners();
	}

	private void _setListeners() {
		JMenuBar mb = this.target_JMenuBar();
		BPAttribute attr = this.m_attr_actionListener;
		if (attr != null) {
			String id = attr.getValue();
			if (id.startsWith("#")) {
				id = id.substring(1);
			}
			ActionListener listener = (ActionListener) this.getOwnerDocument()
					.findTargetById(id);
			this.mMonitor.clear();
			this.mMonitor.addJMenuBar(mb);
			this.mMonitor.setActionListener(listener);
		}
	}

	final MyItemMonitor mMonitor = new MyItemMonitor();

	class MyItemMonitor implements ActionListener {

		private ActionListener mOuterListener;
		private final List<JMenuItem> mItemList;

		public MyItemMonitor() {
			this.mItemList = new Vector<JMenuItem>();
		}

		public void clear() {
			for (JMenuItem item : this.mItemList) {
				item.removeActionListener(this);
			}
			this.mItemList.clear();
		}

		public void setActionListener(ActionListener listener) {
			this.mOuterListener = listener;
		}

		public void addJMenuBar(JMenuBar mb) {
			int cnt = mb.getMenuCount();
			for (int i = cnt - 1; i >= 0; i--) {
				JMenu menu = mb.getMenu(i);
				this.addJMenu(menu, 32);
			}
		}

		private void addJMenu(JMenu menu, int depthLimit) {
			if (depthLimit <= 0) {
				throw new RuntimeException("the menu tree is too deep");
			}
			int cnt = menu.getItemCount();
			for (int i = cnt - 1; i >= 0; i--) {
				JMenuItem item = menu.getItem(i);
				this.addJMenuItem(item);
				if (item instanceof JMenu) {
					this.addJMenu((JMenu) item, depthLimit - 1);
				}
			}
		}

		private void addJMenuItem(JMenuItem item) {
			item.addActionListener(this);
			this.mItemList.add(item);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			ActionListener out = this.mOuterListener;
			if (out != null) {
				out.actionPerformed(e);
			}
		}
	}

}
