package ananas.blueprint4.terminal;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Properties;

import ananas.blueprint4.terminal.loader.CommandLoaderFactory;

public interface Terminal {

	InputStream getInput();

	PrintStream getOutput();

	Map<String, Object> getGlobal();

	Properties getProperties();

	CommandRegistrar getCommandRegistrar();

	Thread prepareStart();

	Runnable getRunnable();

	CommandLoaderFactory getCommandLoaderFactory();

	void execute(String line);

	void close();
}
