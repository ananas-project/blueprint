package ananas.lib.blueprint2.swing;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import ananas.lib.blueprint2.awt.ObjectWrapper;
import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.helper.IBlueprintContext;
import ananas.lib.io.IInputConnection;

public class ImageIconWrapper extends ObjectWrapper implements IconWrapper {

	private IAttr mSrc;

	@Override
	public boolean setAttribute(IAttr attr) {
		String lname = attr.getBlueprintClass().getLocalName();
		if (lname == null) {
			return false;
		} else if ("src".equalsIgnoreCase(lname)) {
			this.mSrc = attr;
			return true;
		} else {
			return super.setAttribute(attr);
		}
	}

	public void onTagEnd() {
		super.onTagEnd();
		if (this.mSrc != null) {
			String url = this.mSrc.getValue();
			this._loadImage(url);
		}
	}

	private ImageIcon _loadImage(String url) {
		try {
			IBlueprintContext context = this.getOwnerDocument()
					.getImplementation().getBlueprintContext();
			IInputConnection conn = (IInputConnection) context.getConnector()
					.open(url);
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[128];
			for (int cb = is.read(buf); cb > 0; cb = is.read(buf)) {
				baos.write(buf, 0, cb);
			}
			buf = baos.toByteArray();
			ImageIcon icon = new ImageIcon(buf);
			this.bindTarget(icon);
			is.close();
			conn.close();
			return icon;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Icon getIcon() {
		return (Icon) this.getTarget();
	}

}
