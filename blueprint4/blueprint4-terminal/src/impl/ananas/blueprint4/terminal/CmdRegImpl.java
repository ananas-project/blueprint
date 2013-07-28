package impl.ananas.blueprint4.terminal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import ananas.blueprint4.terminal.Command;
import ananas.blueprint4.terminal.CommandInfo;
import ananas.blueprint4.terminal.CommandRegistrar;

class CmdRegImpl implements CommandRegistrar {

	final Map<String, CommandInfo> _table;

	public CmdRegImpl() {
		_table = new Hashtable<String, CommandInfo>();
	}

	@Override
	public void register(String fullname, Command cmd) {
		fullname = this.__normalizeName(fullname);
		String[] array = this.stringToArray(fullname);
		String shortName = "";
		if (array != null)
			if (array.length > 0) {
				shortName = array[array.length - 1];
			}
		CommandInfo info = new MyCmdInfo(shortName, fullname, cmd);
		this._table.put(fullname, info);
	}

	@Override
	public Command getCommand(String name) {
		name = this.__normalizeName(name);
		CommandInfo info = this.getCommandInfo(name);
		if (info == null)
			return null;
		return info.getCommand();
	}

	@Override
	public String arrayToString(String[] array) {
		return this.__arrayToString(array, 0, array.length);
	}

	private String __arrayToString(String[] array, int offset, int length) {
		StringBuilder sb = new StringBuilder();
		int end = offset + length;
		for (int i = offset; i < end; i++) {
			String s = array[i];
			if (s != null)
				if (s.length() > 0)
					sb.append(s + ".");
		}
		return sb.toString();
	}

	@Override
	public String[] stringToArray(String s) {
		final List<String> list = new ArrayList<String>();
		final StringBuilder sb = new StringBuilder();
		final char[] chs = s.toCharArray();
		for (char ch : chs) {
			switch (ch) {
			case ' ':
			case 0x0a:
			case 0x0d:
			case 0x09:
				// skip
				break;
			case '.': {
				if (sb.length() > 0) {
					list.add(sb.toString());
				}
				sb.setLength(0);
				break;
			}
			default:
				sb.append(ch);
			}
		}
		if (sb.length() > 0) {
			list.add(sb.toString());
		}
		return list.toArray(new String[list.size()]);
	}

	@Override
	public String arrayToString(String[] array, int offset, int length) {
		return this.__arrayToString(array, offset, length);
	}

	private String __normalizeName(String name) {
		String[] array = this.stringToArray(name);
		return this.arrayToString(array);
	}

	class MyCmdInfo implements CommandInfo {

		private final Command _command;
		private final String _short_name;
		private final String _full_name;

		public MyCmdInfo(String shortName, String fullName, Command cmd) {
			this._command = cmd;
			this._full_name = fullName;
			this._short_name = shortName;
		}

		@Override
		public String getFullName() {
			return this._full_name;
		}

		@Override
		public String getName() {
			return this._short_name;
		}

		@Override
		public Command getCommand() {
			return this._command;
		}
	}

	@Override
	public CommandInfo getCommandInfo(String name) {
		name = this.__normalizeName(name);
		return this._table.get(name);
	}

	@Override
	public List<CommandInfo> listAllCommandInfo() {
		return new ArrayList<CommandInfo>(this._table.values());
	}

}
