package impl.ananas.blueprint4.terminal;

public class DefaultLineParser implements LineParser {

	@Override
	public void parse(String line, LineParserHandler h)
			throws LineParserException {
		CharReader rdr = new CharReader(line, h);
		StringBufferStackNode node = new StringBufferStackNode();
		for (; !rdr.isEOF();) {
			rdr.skipSpace();
			String part = rdr.readPart(node);
			if (part != null) {
				if (part.length() > 0)
					h.onPart(part);
			}
		}
	}

	class CharReader {

		private final char[] chs;
		private final int length;
		private int cnt_read = 0;
		private boolean _is_eof = false;
		private int _next_ch = 0;
		private final LineParserHandler _h;

		public CharReader(String line, LineParserHandler h) {
			this.chs = line.toCharArray();
			this.length = chs.length;
			this._h = h;
			this.readChar();
		}

		public String readPart(StringBufferStackNode node)
				throws LineParserException {
			final StringBuilder sb = node.allocBuffer();
			node = node.nextNode();
			for (int ch = this.getChar(); ch >= 0; ch = this.getChar()) {
				if (this.isSpace(ch)) {
					break;
				} else if (ch == '\'' || ch == '"') {
					String str = this.readCString(ch, node);
					sb.append(str);
				} else {
					String word = this.readWord(node);
					sb.append(word);
				}
			}
			return sb.toString();
		}

		private boolean isSpace(int ch) {
			return (ch == 0x09 || ch == 0x0a || ch == 0x0d || ch == ' ');
		}

		private String readCString(final int ch0, StringBufferStackNode node)
				throws LineParserException {
			final StringBuilder sb = node.allocBuffer();
			node = node.nextNode();
			this.readAndCheck(ch0);
			for (int ch = this.getChar(); ch >= 0; ch = this.getChar()) {
				if (ch == ch0) {
					break;
				} else if (ch == '\\') {
					// JSON style escape
					char s = (char) this.readJSONStyleStringEscape(node);
					sb.append(s);
				} else {
					sb.append((char) this.readChar());
				}
			}
			this.readAndCheck(ch0);
			String str = sb.toString();
			this._h.onCString(str);
			return str;
		}

		private int readJSONStyleStringEscape(StringBufferStackNode node)
				throws LineParserException {
			// final StringBuilder sb = node.allocBuffer();
			node = node.nextNode();
			this.readAndCheck('\\');
			final int ch1 = this.readChar();
			switch (ch1) {
			case 'b':
				return '\b';
			case 'f':
				return '\f';
			case 'n':
				return '\n';
			case 'r':
				return '\r';
			case 't':
				return '\t';
			case 'u':
				int nOut = 0;
				for (int i = 4; i > 0; i--) {
					final int u = this.readChar();
					final int n;
					if ('0' <= u && u <= '9') {
						n = u - '0';
					} else if ('a' <= u && u <= 'f') {
						n = u - 'a' + 10;
					} else if ('A' <= u && u <= 'F') {
						n = u - 'A' + 10;
					} else {
						throw new LineParserException("need a hex here!");
					}
					nOut <<= 4;
					nOut = n & 0x0f;
				}
				return ((char) nOut);
			default:
				return ch1;
			}
		}

		private void readAndCheck(final int ch0) throws LineParserException {
			final int ch = this.readChar();
			if (ch != ch0) {
				final char want, but;
				want = (char) ch0;
				but = (char) ch;
				throw new LineParserException("want a '" + want
						+ "' here, but a '" + but + "'.");
			}
		}

		private int readChar() {
			final int ret = this._next_ch;
			final int index = this.cnt_read;
			if (index < this.length) {
				this._next_ch = this.chs[index];
				this.cnt_read = index + 1;
			} else {
				this._next_ch = -1;
				this._is_eof = true;
			}
			return ret;
		}

		private int getChar() {
			return this._next_ch;
		}

		private String readWord(StringBufferStackNode node) {
			final StringBuilder sb = node.allocBuffer();
			node = node.nextNode();
			for (int ch = this.getChar(); ch >= 0; ch = this.getChar()) {
				if (this.isSpace(ch)) {
					break;
				} else if (ch == '\'' || ch == '"') {
					break;
				} else {
					sb.append((char) this.readChar());
				}
			}
			return sb.toString();
		}

		public void skipSpace() {
			for (int ch = this.getChar(); ch >= 0; ch = this.getChar()) {
				if (this.isSpace(ch)) {
					this.readChar();
				} else {
					break;
				}
			}
		}

		public boolean isEOF() {
			return this._is_eof;
		}
	}

	class StringBufferStackNode {

		private StringBufferStackNode _next;
		private final StringBuilder _buffer = new StringBuilder();

		public StringBufferStackNode nextNode() {
			StringBufferStackNode node = this._next;
			node.hashCode();// anti null
			return node;
		}

		public StringBuilder allocBuffer() {
			StringBufferStackNode node = this._next;
			if (node == null) {
				node = new StringBufferStackNode();
				this._next = node;
			}
			StringBuilder sb = this._buffer;
			sb.setLength(0);
			return sb;
		}
	}

}
