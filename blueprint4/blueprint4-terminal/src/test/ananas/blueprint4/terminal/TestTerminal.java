package test.ananas.blueprint4.terminal;

import java.util.Properties;

import ananas.blueprint4.terminal.Terminal;
import ananas.blueprint4.terminal.TerminalFactory;
import ananas.blueprint4.terminal.loader.CommandLoader;

public class TestTerminal {

	public static void main(String[] arg) {

		(new TestTerminal()).run();

	}

	private void run() {
		(new EnvironmentForTesting()).init();
		TerminalFactory tf = TerminalFactory.Agent.newInstance();
		Terminal t = tf.newTerminal(null);
		CommandLoader ldr = t.getCommandLoaderFactory().newLoader(t);
		ldr.load("resource:///commands.xml");

		long now = System.currentTimeMillis();
		String prompt = "login_" + now + "# ";
		String welcome = "welcome to " + this + "\nnow, time is " + now + "\n";
		String bye = "The terminal is end!";
		Properties prop = t.getProperties();
		prop.setProperty("terminal.welcome", welcome);
		prop.setProperty("terminal.bye", bye);
		prop.setProperty("terminal.prompt", prompt);

		t.getRunnable().run();

	}
}
