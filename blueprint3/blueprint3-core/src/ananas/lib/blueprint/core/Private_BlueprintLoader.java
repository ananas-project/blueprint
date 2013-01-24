package ananas.lib.blueprint.core;

import java.io.InputStream;
import java.util.Properties;

class Private_BlueprintLoader {

	private static Blueprint s_inst;

	public static Blueprint loadInstance() {
		Blueprint inst = s_inst;
		if (inst == null) {
			Private_BlueprintLoader impl = new Private_BlueprintLoader();
			inst = impl.doLoad();
			s_inst = inst;
		}
		return inst;
	}

	private Private_BlueprintLoader() {
	}

	private Blueprint doLoad() {
		try {
			InputStream in = this.getClass().getResourceAsStream(
					"blueprint.properties");
			Properties prop = new Properties();
			prop.load(in);
			String key = "BlueprintFactory";
			String value = prop.getProperty(key);
			Class<?> cls = Class.forName(value);
			BlueprintFactory factory = (BlueprintFactory) cls.newInstance();
			return factory.newBlueprint();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
