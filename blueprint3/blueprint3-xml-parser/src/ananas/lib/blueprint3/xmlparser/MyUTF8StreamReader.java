package ananas.lib.blueprint3.xmlparser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MyUTF8StreamReader extends Reader {

	private final InputStream mIn;

	public MyUTF8StreamReader(InputStream in) {
		this.mIn = in;
	}

	@Override
	public void close() throws IOException {
		this.mIn.close();
	}

	@Override
	public int read(char[] buf, int off, int len) throws IOException {

		if (len > 0) {
			int ch = this._readChar();
			if (ch >= 0) {
				buf[off] = (char) ch;
				return 1;
			} else {
				return 0;
			}

		} else {
			return 0;
		}
	}

	@Override
	public int read() throws IOException {
		return this._readChar();
	}

	private int _readChar() throws IOException {
		final InputStream in = this.mIn;
		final int b0 = in.read();
		if (b0 < 0) {
			// EOF
			return -1;
		}
		// shift b0{
		int cnt = 0;
		int mask = 0x00ff;
		for (; (b0 | mask) == 0x00ff; cnt++) {
			mask = mask >> 1;
		}
		int ret = (b0 & mask);
		final int cntAddition = (b0 <= 0x7f) ? 0 : (cnt - 2);
		// }end
		for (int i = cntAddition; i > 0; i--) {
			final int b = in.read();
			if (b < 0) {
				// EOF
				return -1;
			}
			// shift b-addition{
			ret = ((ret << 6) | (b & 0x3f));
			// }end
		}
		return ret;
	}

}
