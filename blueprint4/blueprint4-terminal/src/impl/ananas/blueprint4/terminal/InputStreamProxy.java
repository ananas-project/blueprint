package impl.ananas.blueprint4.terminal;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamProxy extends InputStream {

	private final InputStream _inner;
	private boolean _is_closed = false;

	public InputStreamProxy(InputStream inner) {
		this._inner = inner;
	}

	@Override
	public int read() throws IOException {
		if (this._is_closed) {
			return -1;
		} else {
			return _inner.read();
		}
	}

	@Override
	public void close() {
		this._is_closed = true;
	}

}
