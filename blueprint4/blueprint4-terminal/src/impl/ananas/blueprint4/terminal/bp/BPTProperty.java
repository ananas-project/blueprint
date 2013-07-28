package impl.ananas.blueprint4.terminal.bp;

import ananas.lib.localization.Locale;

public class BPTProperty extends BPTObject {

	private String _key;
	private String _value;
	private String _lang;
	private Locale _local;

	protected boolean onSetAttribute(String uri, String localName, String value) {
		if (localName == null) {
			return false;
		} else if (localName.equals("lang")) {
			this._lang = value;
		} else if (localName.equals("key")) {
			this._key = value;
		} else {
			return super.onSetAttribute(uri, localName, value);
		}
		return true;
	}

	public String getKey() {
		return this._key;
	}

	public String getValue() {
		return this._value;
	}

	public Locale getLocal() {
		Locale local = this._local;
		if (local == null) {

			if (local == null)
				local = Locale.worldwide;
			this._local = local;
		}
		return local;
	}

}
