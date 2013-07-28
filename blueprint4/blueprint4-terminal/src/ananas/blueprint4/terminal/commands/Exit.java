package ananas.blueprint4.terminal.commands;

import java.io.PrintStream;

import ananas.blueprint4.terminal.Command;
import ananas.blueprint4.terminal.ExecuteContext;

public class Exit implements Command {

	@Override
	public void execute(ExecuteContext context) {
		PrintStream out = context.getTerminal().getOutput();
		out.println("close this terminal ...");
		context.getTerminal().close();
	}

}
