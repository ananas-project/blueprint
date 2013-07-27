package impl.ananas.blueprint4.terminal;

import java.io.PrintStream;
import java.util.Properties;

import ananas.blueprint4.terminal.Command;
import ananas.blueprint4.terminal.CommandRegistrar;
import ananas.blueprint4.terminal.ExecuteContext;
import ananas.blueprint4.terminal.Terminal;
import ananas.lib.util.logging.Logger;

public class MyCmdExe implements Runnable, ExecuteContext {

	final static Logger log = Logger.Agent.getLogger();

	private final String _line;
	private final Terminal _terminal;

	public MyCmdExe(Terminal terminal, String line) {
		this._terminal = terminal;
		this._line = line;
	}

	private void __exe(Command cmd, String name, DefaultLineParserHandler lp) {
		try {
			this._ec_cmdName = name;
			this._ec_flags = lp.getFlags();
			this._ec_param = lp.getParameters();
			cmd.execute(this);
		} catch (Exception e) {
			log.error(e);
		}
	}

	@Override
	public void run() {

		String line = this._line;
		Terminal terminal = this._terminal;
		if (line.length() <= 0) {
			return;
		}
		if (line.equals("exit")) {
			terminal.close();
			return;
		}

		DefaultLineParserHandler lph = new DefaultLineParserHandler();
		LineParser lp = new DefaultLineParser();
		try {
			lp.parse(line, lph);
		} catch (LineParserException e) {
			PrintStream out = terminal.getOutput();
			out.println(e + "");
			return;
		}

		int name_max = lph.getNameMax();
		String[] stanzas = lph.getParameters();
		CommandRegistrar cmdReg = terminal.getCommandRegistrar();
		for (int cnt = name_max; cnt > 0; cnt--) {
			String name = cmdReg.arrayToString(stanzas, 0, cnt);
			Command cmd = cmdReg.get(name);
			if (cmd == null) {
				continue;
			} else {
				// got command!
				this.__exe(cmd, name, lph);
				return;
			}
		}
		return;
	}

	private Properties _ec_flags;
	private String[] _ec_param;
	private String _ec_cmdName;

	@Override
	public Terminal getTerminal() {
		return this._terminal;
	}

	@Override
	public String[] getParameters() {
		return this._ec_param;
	}

	@Override
	public Properties getFlags() {
		return this._ec_flags;
	}

	@Override
	public String getCommandName() {
		return this._ec_cmdName;
	}

}
