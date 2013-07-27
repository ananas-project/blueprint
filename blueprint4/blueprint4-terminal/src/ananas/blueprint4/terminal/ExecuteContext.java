package ananas.blueprint4.terminal;

import java.util.Properties;

public interface ExecuteContext {

	Terminal getTerminal();

	String getCommandName();

	String[] getParameters();

	int countNames();

	Properties getFlags();
}
