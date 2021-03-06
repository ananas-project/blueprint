package test.ananas.blueprint4.terminal;

import java.io.PrintStream;
import java.util.List;
import java.util.Properties;

import ananas.blueprint4.terminal.Command;
import ananas.blueprint4.terminal.ExecuteContext;
import ananas.blueprint4.terminal.Terminal;
import ananas.blueprint4.terminal.TerminalFactory;
import ananas.blueprint4.terminal.loader.CommandLoader;
import ananas.lib.localization.Locale;
import ananas.lib.localization.LocalizationManager;

public class TestTerminal {

	public static void main(String[] arg) {

		(new EnvironmentForTesting()).init();

		LocalizationManager lm = LocalizationManager.Agent.getManager();
		List<Locale> locales = lm.listAllLocales();
		for (Locale loc : locales) {
			System.out.println("support " + loc);
		}

		(new TestTerminal()).run();

	}

	private void run() {

		// create terminal
		TerminalFactory tf = TerminalFactory.Agent.newInstance();
		Terminal t = tf.newTerminal(null);

		// load commands
		t.getCommandRegistrar().register("git.init", new MyCmdGitInit());
		CommandLoader ldr = t.getCommandLoaderFactory().newLoader(t);
		ldr.load("resource:///test/ananas/blueprint4/terminal/terminal-commands.xml");

		// set properties for terminal
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

	class MyCmdGitInit implements Command {

		public MyCmdGitInit() {
		}

		@Override
		public void execute(ExecuteContext context) {
			PrintStream out = context.getTerminal().getOutput();
			String name = context.getParameters()[context.countNames()];
			out.println("command name = " + context.getCommandName());
			out.println("init git repo named '" + name + "'");
		}
	}

}
