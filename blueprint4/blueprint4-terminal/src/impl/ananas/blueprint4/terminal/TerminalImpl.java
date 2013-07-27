package impl.ananas.blueprint4.terminal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import ananas.blueprint4.terminal.CommandRegistrar;
import ananas.blueprint4.terminal.Terminal;
import ananas.blueprint4.terminal.TerminalConfig;
import ananas.blueprint4.terminal.loader.CommandLoaderFactory;
import ananas.lib.util.logging.Logger;

class TerminalImpl implements Terminal {

	static final Logger log = Logger.Agent.getLogger();

	private Runnable _runn;
	private final CommandRegistrar _cmd_reg;
	private final Properties _properties;
	private final Map<String, Object> _global;
	private final PrintStream _out;
	private final InputStream _in;
	private final CommandLoaderFactory _cmd_ldr_fact;

	public TerminalImpl(TerminalConfig config) {
		this._in = new InputStreamProxy(config.in);
		this._out = this.__wrapOutput(config.out);
		this._cmd_ldr_fact = config.cmdLoaderFactory;
		this._properties = new Properties();
		this._global = new Hashtable<String, Object>();
		this._cmd_reg = new CmdRegImpl();
	}

	private PrintStream __wrapOutput(OutputStream out) {
		try {
			return new PrintStream(out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e);
			return new PrintStream(out);
		}
	}

	@Override
	public InputStream getInput() {
		return this._in;
	}

	@Override
	public PrintStream getOutput() {
		return this._out;
	}

	@Override
	public Map<String, Object> getGlobal() {
		return this._global;
	}

	@Override
	public Properties getProperties() {
		return this._properties;
	}

	@Override
	public CommandRegistrar getCommandRegistrar() {
		return this._cmd_reg;
	}

	@Override
	public Thread prepareStart() {
		return (new Thread(this.getRunnable()));
	}

	@Override
	public Runnable getRunnable() {
		Runnable runn = _runn;
		if (runn == null) {
			runn = new DaemonRunner(this);
			_runn = runn;
		}
		return runn;
	}

	@Override
	public CommandLoaderFactory getCommandLoaderFactory() {
		return this._cmd_ldr_fact;
	}

	@Override
	public void close() {
		try {
			this.getInput().close();
		} catch (IOException e) {
			log.error(e);
		}
		String key = Terminal.class.getName();
		this.getGlobal().remove(key);
	}

	@Override
	public void execute(String line) {
		try {
			Runnable runn = new MyCmdExe(this, line);
			runn.run();
		} catch (Exception e) {
			log.error(e);
		}
	}

}
