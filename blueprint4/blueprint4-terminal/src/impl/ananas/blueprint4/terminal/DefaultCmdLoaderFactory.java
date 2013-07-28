package impl.ananas.blueprint4.terminal;

import impl.ananas.blueprint4.terminal.bp.BPTCommandItem;
import impl.ananas.blueprint4.terminal.bp.BPTCommandItemListener;
import impl.ananas.blueprint4.terminal.bp.BPTCommandSet;

import java.io.IOException;

import ananas.blueprint4.core.BPEnvironment;
import ananas.blueprint4.core.Blueprint;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.terminal.Command;
import ananas.blueprint4.terminal.CommandRegistrar;
import ananas.blueprint4.terminal.Terminal;
import ananas.blueprint4.terminal.loader.CommandLoader;
import ananas.blueprint4.terminal.loader.CommandLoaderFactory;
import ananas.lib.util.logging.Logger;

public class DefaultCmdLoaderFactory implements CommandLoaderFactory {

	final static Logger log = Logger.Agent.getLogger();

	@Override
	public CommandLoader newLoader(Terminal terminal) {
		return new MyCommandLoader(terminal);
	}

	static class MyCommandLoader implements CommandLoader {

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

			try {
				BPEnvironment bp = this.getBlueprint();
				BPDocument doc = bp.loadBPDocument(url);
				BPTCommandSet root = (BPTCommandSet) doc.getRootElement();
				CommandRegistrar reg = this._term.getCommandRegistrar();
				root.iterateItems(new MyCmdItemListener(reg), true);

			} catch (IOException e) {
				log.error(e);
			}
		}

		private BPEnvironment getBlueprint() {
			return Blueprint.Util.getDefault().getEnvironment();
		}
	}

	static class MyCmdItemListener implements BPTCommandItemListener {

		private final CommandRegistrar _reg;

		public MyCmdItemListener(CommandRegistrar reg) {
			this._reg = reg;
		}

		@Override
		public void onItem(BPTCommandItem item) {
			try {
				final Class<?> cls = item.getCommandClass();
				if (cls != null) {
					String fullname = item.getFullName();
					Command cmd = (Command) cls.newInstance();
					_reg.register(fullname, cmd);
				}
			} catch (Exception e) {
				log.error(e);
			}
		}
	}

}
