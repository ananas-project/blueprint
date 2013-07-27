package ananas.blueprint4.terminal;

public interface CommandRegistrar {

	void register(String name, Command cmd);

	Command get(String name);

	String arrayToString(String[] array, int offset, int length);

	String arrayToString(String[] array);

	String[] stringToArray(String s);

}
