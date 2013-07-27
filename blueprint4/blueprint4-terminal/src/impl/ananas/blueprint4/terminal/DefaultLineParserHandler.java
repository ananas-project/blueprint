package impl.ananas.blueprint4.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ananas.lib.util.logging.Logger;

public class DefaultLineParserHandler implements LineParserHandler {

	final static Logger log = Logger.Agent.getLogger();

	// private String[] _params;
	private final Properties _flags = new Properties();
	private final List<String> _plist = new ArrayList<String>();
	private int _name_max = 0;
	private boolean _name_max_ok = false;

	public Properties getFlags() {
		return this._flags;
	}

	public String[] getParameters() {
		List<String> list = this._plist;
		return list.toArray(new String[list.size()]);
	}

	public int getNameMax() {
		return this._name_max;
	}

	@Override
	public void onPart(String part) {

		// log.trace(this + ".onPart: " + part);

		if (part.startsWith("-")) {
			this.__mark_name_max_ok();
			int i = part.indexOf('=');
			if (i < 0) {
				// no '='
				this._flags.setProperty(part, "");
			} else {
				String k, v;
				k = part.substring(0, i);
				v = part.substring(i + 1);
				this._flags.setProperty(k, v);
			}
		} else {
			this._plist.add(part);
			if (!this._name_max_ok) {
				this._name_max++;
			}
		}
	}

	@Override
	public void onCString(String str) {
		this.__mark_name_max_ok();
	}

	private void __mark_name_max_ok() {
		this._name_max_ok = true;
	}

}
