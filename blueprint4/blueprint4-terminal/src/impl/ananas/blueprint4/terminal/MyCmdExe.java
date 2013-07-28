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

		final String line = this._line;
		final Terminal terminal = this._terminal;
		if (line.length() <= 0) {
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
		String[] cmds = lph.getParameters();
		CommandRegistrar cmdReg = terminal.getCommandRegistrar();
		for (int cnt = name_max; cnt > 0; cnt--) {
			String qname = cmdReg.arrayToString(cmds, 0, cnt);
			Command cmd = cmdReg.getCommand(qname);
			if (cmd == null) {
				continue;
			} else {
				// got command!
				this._ec_countNames = cnt;
				this.__exe(cmd, qname, lph);
				return;
			}
		}
		// no command match

		switch (cmds.length) {
		case 0:
			return;
		case 1:
			if ("exit".equals(cmds[0])) {
				terminal.close();
				return;
			}
		default:
		}
		terminal.getOutput().println("Bad command.");
	}

	private Properties _ec_flags;
	private String[] _ec_param;
	private String _ec_cmdName;
	private int _ec_countNames;

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

	@Override
	public int countNames() {
		return this._ec_countNames;
	}

}
