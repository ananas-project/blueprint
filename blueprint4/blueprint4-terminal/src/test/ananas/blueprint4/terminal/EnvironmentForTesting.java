package test.ananas.blueprint4.terminal;

import ananas.lib.util.PropertiesLoader;

public class EnvironmentForTesting {

	public void init() {
		PropertiesLoader.Util.loadPropertiesToSystem(this, "system.properties");
	}

}
