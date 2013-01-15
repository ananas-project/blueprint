package ananas.lib.blueprint2.swing;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import ananas.lib.blueprint2.dom.IAttr;

public class JToolBarWrapper extends JComponentWrapper {

	private IAttr mFloatable;
	private IAttr m_attr_actionListener;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;

		} else if (name.equals("actionListener")) {
			this.m_attr_actionListener = attr;

		} else if (name.equals("floatable")) {
			this.mFloatable = attr;
		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	public void onTagEnd() {
		super.onTagEnd();

		JToolBar tb = (JToolBar) this.getTarget(true);

		if (this.mFloatable != null) {
			boolean b = this.booleanFromAttr(mFloatable);
			tb.setFloatable(b);
		}

		if (this.m_attr_actionListener != null) {
			String uri = this.m_attr_actionListener.getValue();
			ActionListener listener = (ActionListener) this.getOwnerDocument()
					.findTargetByURI(uri);
			this._listenToolbar(listener);
		}
	}

	private void _listenToolbar(ActionListener listener) {
		JToolBar toolbar = (JToolBar) this.getTarget(true);
		int cnt = toolbar.getComponentCount();
		for (int i = 0; i < cnt; i++) {
			Component comp = toolbar.getComponent(i);
			if (comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(listener);
			}
		}
	}
}
