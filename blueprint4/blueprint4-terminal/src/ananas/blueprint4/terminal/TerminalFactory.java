package ananas.blueprint4.terminal;

import ananas.lib.util.SingletonLoader;

public interface TerminalFactory {

	Terminal newTerminal(TerminalConfig config);

	class Agent {

		public static TerminalFactory newInstance() {
			TerminalFactory tf = (TerminalFactory) SingletonLoader
					.load(TerminalFactory.class);
			return tf;
		}

	}

}
