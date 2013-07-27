package impl.ananas.blueprint4.terminal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Properties;

import ananas.blueprint4.terminal.Terminal;
import ananas.lib.util.logging.Logger;

class DaemonRunner implements Runnable {

	final static Logger log = Logger.Agent.getLogger();

	private final Terminal _termi;

	public DaemonRunner(Terminal terminal) {
		this._termi = terminal;
	}

	@Override
	public void run() {
		try {
			final Terminal terminal = _termi;
			final Properties prop = terminal.getProperties();
			final Map<String, Object> global = terminal.getGlobal();
			final PrintStream out = terminal.getOutput();
			final InputStream in = terminal.getInput();
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// print terminal welcome
			String welcome = prop.getProperty("terminal.welcome");
			if (welcome != null)
				out.println(welcome);
			// loop
			final String key_terminal = Terminal.class.getName();
			global.put(key_terminal, terminal);
			for (;;) {
				// terminal close detect
				Object g_termi = global.get(key_terminal);
				if (g_termi == null) {
					break;
				}
				// print prompt
				String prompt = prop.getProperty("terminal.prompt");
				if (prompt == null)
					prompt = ">";
				out.print(prompt);
				// input one line
				String line = this.__readLine(in, baos);
				if (line == null)
					break;
				// process line
				terminal.execute(line);
			}
			// print terminal bye-bye
			String bye = prop.getProperty("terminal.bye");
			if (bye != null)
				out.println(bye);

		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * @param baos
	 * @return if EOF, return null;
	 * @throws IOException
	 * */
	private String __readLine(InputStream in, ByteArrayOutputStream baos)
			throws IOException {

		baos.reset();
		for (int b = in.read(); b >= 0; b = in.read()) {
			switch (b) {
			case 0x0a:
			case 0x0d: {
				byte[] ba = baos.toByteArray();
				String line = new String(ba, "UTF-8");
				return line;
			}
			default:
				baos.write(b);
			}
		}
		return null;
	}
}
