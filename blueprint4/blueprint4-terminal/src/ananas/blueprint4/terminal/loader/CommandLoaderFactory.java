package ananas.blueprint4.terminal.loader;

import ananas.blueprint4.terminal.Terminal;

public interface CommandLoaderFactory {

	CommandLoader newLoader(Terminal terminal);
}
