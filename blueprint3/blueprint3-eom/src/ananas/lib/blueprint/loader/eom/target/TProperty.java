package ananas.lib.blueprint.loader.eom.target;

public class TProperty {

	private String mValue;
	private final String mKey;

	public TProperty(String key) {
		this.mKey = key;
	}

	public TProperty(String key, String value) {
		this.mKey = key;
		this.mValue = value;
	}

	public void setValue(String value) {
		this.mValue = value;
	}

	public String getKey() {
		return this.mKey;
	}

	public String getValue() {
		return this.mValue;
	}

}
