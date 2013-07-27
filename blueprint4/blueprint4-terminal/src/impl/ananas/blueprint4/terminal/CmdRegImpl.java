package impl.ananas.blueprint4.terminal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import ananas.blueprint4.terminal.Command;
import ananas.blueprint4.terminal.CommandRegistrar;

class CmdRegImpl implements CommandRegistrar {

	final Map<String, Command> _table;

	public CmdRegImpl() {
		_table = new Hashtable<String, Command>();
	}

	@Override
	public void register(String name, Command cmd) {
		String[] array = this.stringToArray(name);
		this.__reg(array, cmd);
	}

	private void __reg(String[] array, Command cmd) {
		String key = this.arrayToString(array);
		this._table.put(key, cmd);
	}

	@Override
	public Command get(String name) {
		String[] array = this.stringToArray(name);
		return this.__get(array);
	}

	private Command __get(String[] array) {
		String key = this.arrayToString(array);
		return this._table.get(key);
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
				String s2 = sb.toString();
				sb.setLength(0);
				if (s2.length() > 0)
					list.add(s2);
				break;
			}
			default:
				sb.append(ch);
			}
		}
		return list.toArray(new String[list.size()]);
	}

	@Override
	public String arrayToString(String[] array, int offset, int length) {
		return this.__arrayToString(array, offset, length);
	}

}
