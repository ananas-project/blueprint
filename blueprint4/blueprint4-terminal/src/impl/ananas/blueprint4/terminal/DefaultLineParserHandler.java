package impl.ananas.blueprint4.terminal;

import java.util.Properties;

public class DefaultLineParserHandler implements LineParserHandler {

	private String[] _params;
	private Properties _flags;
	private int _name_max;

	public Properties getFlags() {
		return this._flags;
	}

	public String[] getParameters() {
		return this._params;
	}

	public int getNameMax() {
		return this._name_max;
	}

	public void parseLine(String line) {
		final char[] chs = line.toCharArray();
		for (char ch : chs) {
		}
		// TODO
	}

	@Override
	public void onPart(LineParser parser, String part) {

		System.out.println(this + ".onPart: " + part);

	}

}
