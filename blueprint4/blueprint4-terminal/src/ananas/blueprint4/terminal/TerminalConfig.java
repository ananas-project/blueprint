package ananas.blueprint4.terminal;

import java.io.InputStream;
import java.io.OutputStream;

import ananas.blueprint4.terminal.loader.CommandLoaderFactory;

public class TerminalConfig {

	public InputStream in;
	public OutputStream out;
	public CommandLoaderFactory cmdLoaderFactory;

	public TerminalConfig(TerminalConfig init) {
		if (init != null) {
			this.in = init.in;
			this.out = init.out;
			this.cmdLoaderFactory = init.cmdLoaderFactory;
		}
	}
}
