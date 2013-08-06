package ananas.blueprint4.terminal.commands;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ananas.blueprint4.terminal.Command;
import ananas.blueprint4.terminal.CommandInfo;
import ananas.blueprint4.terminal.CommandRegistrar;
import ananas.blueprint4.terminal.ExecuteContext;

public class Help implements Command {

	@Override
	public void execute(ExecuteContext context) {

		PrintStream out = context.getTerminal().getOutput();
		out.println("this is help for terminal");

		CommandRegistrar cmdreg = context.getTerminal().getCommandRegistrar();

		List<CommandInfo> infos = cmdreg.listAllCommandInfo();
		List<String> cmds = new ArrayList<String>();
		for (CommandInfo info : infos) {
			cmds.add(info.getFullName());
		}
		Collections.sort(cmds);
		for (String cmd : cmds) {
			String name = cmd;
			out.println("cmd:" + name);
		}
	}
}
