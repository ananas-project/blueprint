package ananas.blueprint4.terminal;

import ananas.lib.localization.Locale;

public interface CommandInfo {

	String getFullName();

	String getName();

	Command getCommand();

	void setProperty(String key, String value, Locale local);

	void setProperty(String key, String value);

	String getProperty(String key, Locale local);

	String getProperty(String key);

}
