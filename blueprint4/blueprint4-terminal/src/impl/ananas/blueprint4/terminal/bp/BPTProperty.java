package impl.ananas.blueprint4.terminal.bp;

public class BPTProperty extends BPTObject {

	private String _key;
	private String _value;

	protected boolean onSetAttribute(String uri, String localName, String value) {
		if (localName == null) {
			return false;
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

}
