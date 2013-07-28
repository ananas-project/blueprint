package impl.ananas.blueprint4.terminal.bp;

import java.util.ArrayList;
import java.util.List;

import ananas.blueprint4.core.lang.BPNode;

public class BPTCommandItem extends BPTObject {

	private final List<BPTProperty> _items = new ArrayList<BPTProperty>();
	private String _name;// short command name
	private BPTCommandItem _parent;
	private String _package;
	private String _class_name;

	protected boolean onAppendChild(BPNode child) {
		if (child instanceof BPTProperty) {
			BPTProperty prop = (BPTProperty) child;
			_items.add(prop);
		} else {
			return super.onAppendChild(child);
		}
		return true;
	}

	public void setParentItem(BPTCommandItem parent) {
		this._parent = parent;
	}

	public BPTCommandItem getParentItem() {
		return this._parent;
	}

	public String getName() {
		String name = _name;
		if (name == null) {
			return "";
		} else {
			return name;
		}
	}

	protected boolean onSetAttribute(String uri, String localName, String value) {
		if (localName == null) {
			return false;
		} else if (localName.equals("package")) {
			this._package = value;
		} else if (localName.equals("class")) {
			this._class_name = value;
		} else if (localName.equals("name")) {
			_name = value;
		} else {
			return super.onSetAttribute(uri, localName, value);
		}
		return true;
	}

	public String getFullName() {
		BPTCommandItem parent = this.getParentItem();
		if (parent == null) {
			return this.getName();
		} else {
			return parent.getFullName() + "." + this.getName();
		}
	}

	/**
	 * @param recursion
	 *            = "-R"
	 * */
	public void iterateItems(BPTCommandItemListener listener, boolean recursion) {
		listener.onItem(this);
	}

	/**
	 * @return null,if no this command
	 * */
	public Class<?> getCommandClass() {
		return null;
	}

	public String getPackageName() {
		String pname = this._package;
		if (pname == null) {
			BPTCommandItem parent = this.getParentItem();
			if (parent != null) {
				pname = parent.getPackageName();
			}
		}
		return pname;
	}

	public String getClassName() {
		String cn = this._class_name;
		if (cn == null) {
			return null;
		}
		cn = cn.trim();
		if (cn.startsWith(".")) {
			// need a package name
			return this.getPackageName() + cn;
		} else {
			return cn;
		}
	}

}
