package impl.ananas.blueprint4.core.namespace;

import java.util.Properties;

public class Tar_head {

	final Properties _properties = new Properties();

	public void setProperty(Tar_property prop) {
		String key = prop.getKey();
		String value = prop.getValue();
		this._properties.setProperty(key, value);
	}

	public Properties getProperties() {
		return this._properties;
	}

}
