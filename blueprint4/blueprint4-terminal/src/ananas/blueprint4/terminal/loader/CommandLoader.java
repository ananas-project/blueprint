package ananas.blueprint4.terminal.loader;

import ananas.blueprint4.terminal.Terminal;

public interface CommandLoader {

	Terminal getTerminal();

	void load(String url);

}
