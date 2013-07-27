package impl.ananas.blueprint4.terminal;

import ananas.blueprint4.terminal.Terminal;
import ananas.blueprint4.terminal.TerminalConfig;
import ananas.blueprint4.terminal.TerminalFactory;

public class TerminalFactoryImpl implements TerminalFactory {

	@Override
	public Terminal newTerminal(final TerminalConfig config) {
		final TerminalConfig conf = new TerminalConfig(config);
		if (conf.in == null) {
			conf.in = System.in;
		}
		if (conf.out == null) {
			conf.out = System.out;
		}
		if (conf.cmdLoaderFactory == null) {
			conf.cmdLoaderFactory = new DefaultCmdLoaderFactory();
		}
		return new TerminalImpl(conf);
	}
}
