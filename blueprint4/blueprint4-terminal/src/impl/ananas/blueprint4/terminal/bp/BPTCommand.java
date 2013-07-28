package impl.ananas.blueprint4.terminal.bp;

import ananas.lib.util.logging.Logger;

public class BPTCommand extends BPTCommandItem {

	final static Logger log = Logger.Agent.getLogger();

	private Class<?> _class;

	protected boolean onSetAttribute(String uri, String localName, String value) {
		if (localName == null) {
			return false;
		} else {
			return super.onSetAttribute(uri, localName, value);
		}
		// return true;
	}

	public Class<?> getCommandClass() {
		try {
			Class<?> cls = this._class;
			if (cls == null) {
				String cName = this.getClassName();
				if (cName == null)
					return null;
				cls = Class.forName(cName);
				this._class = cls;
				return cls;
			}
		} catch (ClassNotFoundException e) {
			log.error(e);
		}
		return null;
	}
}
