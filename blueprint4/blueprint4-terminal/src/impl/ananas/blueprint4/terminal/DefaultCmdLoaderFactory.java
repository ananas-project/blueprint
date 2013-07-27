package impl.ananas.blueprint4.terminal;

import ananas.blueprint4.terminal.Terminal;
import ananas.blueprint4.terminal.loader.CommandLoader;
import ananas.blueprint4.terminal.loader.CommandLoaderFactory;

public class DefaultCmdLoaderFactory implements CommandLoaderFactory {

	@Override
	public CommandLoader newLoader(Terminal terminal) {
		return new MyCommandLoader(terminal);
	}

	class MyCommandLoader implements CommandLoader {

		private final Terminal _term;

		public MyCommandLoader(Terminal terminal) {
			this._term = terminal;
		}

		@Override
		public Terminal getTerminal() {
			return this._term;
		}

		@Override
		public void load(String url) {
			// TODO Auto-generated method stub

		}
	}
}
