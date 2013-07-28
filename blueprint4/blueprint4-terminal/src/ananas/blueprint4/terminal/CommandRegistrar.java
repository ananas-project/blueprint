package ananas.blueprint4.terminal;

import java.util.List;

public interface CommandRegistrar {

	CommandInfo register(String name, Command cmd);

	Command getCommand(String name);

	CommandInfo getCommandInfo(String name);

	String arrayToString(String[] array, int offset, int length);

	String arrayToString(String[] array);

	String[] stringToArray(String s);

	List<CommandInfo> listAllCommandInfo();

}
