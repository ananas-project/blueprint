package ananas.lib.blueprint2.swing;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.INode;
import ananas.lib.blueprint2.dom.IText;

public class JLabelWrapper extends JComponentWrapper {

	private IAttr mText;
	private StringBuilder mStringBuilder;
	private String m_attr_horizontalAlignment;
	private String m_attr_verticalAlignment;
	private Icon mIcon;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;

		} else if (name.equals("text")) {
			this.mText = attr;

		} else if (name.equals("horizontalAlignment")) {
			this.m_attr_horizontalAlignment = attr.getValue();

		} else if (name.equals("verticalAlignment")) {
			this.m_attr_verticalAlignment = attr.getValue();

		} else {
			return super.setAttribute(attr);
		}
		return true;
	}

	@Override
	public void onTagBegin() {
		super.onTagBegin();
		JLabel label = this.getJLabel(true);
		if (this.mText != null) {
			String s = this.stringFromAttr(this.mText);
			label.setText(s);
		}
	}

	private JLabel getJLabel(boolean create) {
		return (JLabel) this.getTarget(create);
	}

	@Override
	public boolean onAppendChild(INode child) {
		if (child instanceof IText) {
			this.appendText((IText) child);
			return true;
		} else if (child instanceof IconWrapper) {
			this._setIcon((IconWrapper) child);
			return true;
		} else {
			return super.onAppendChild(child);
		}
	}

	private void _setIcon(IconWrapper child) {
		Icon icon = child.getIcon();
		this.mIcon = icon;
	}

	private void appendText(IText txt) {
		String data = txt.getData();
		StringBuilder sb = this._getStringBuilder(true);
		if (sb.length() > 0) {
			sb.append(' ');
		}
		sb.append(data);
	}

	private StringBuilder _getStringBuilder(boolean create) {
		StringBuilder sb = this.mStringBuilder;
		if (sb == null && create) {
			this.mStringBuilder = sb = new StringBuilder();
		}
		return sb;
	}

	public void onTagEnd() {
		super.onTagEnd();
		JLabel label = this.getJLabel(true);
		StringBuilder sb = this._getStringBuilder(false);
		if (sb != null) {
			String s = sb.toString();
			label.setText(s);
		}

		if (this.m_attr_horizontalAlignment != null) {
			String str = this.m_attr_horizontalAlignment;
			int n;
			if (str == null)
				n = 0;

			else if (str.equals("LEFT"))
				n = SwingConstants.LEFT;
			else if (str.equals("CENTER"))
				n = SwingConstants.CENTER;
			else if (str.equals("RIGHT"))
				n = SwingConstants.RIGHT;

			else
				n = 0;
			label.setHorizontalAlignment(n);
		}

		if (this.m_attr_verticalAlignment != null) {
			String str = this.m_attr_verticalAlignment;
			int n;
			if (str == null)
				n = 0;

			else if (str.equals("TOP"))
				n = SwingConstants.TOP;
			else if (str.equals("CENTER"))
				n = SwingConstants.CENTER;
			else if (str.equals("BOTTOM"))
				n = SwingConstants.BOTTOM;

			else
				n = 0;
			label.setVerticalAlignment(n);
		}

		if (this.mIcon != null) {
			label.setIcon(this.mIcon);
		}
	}
}
