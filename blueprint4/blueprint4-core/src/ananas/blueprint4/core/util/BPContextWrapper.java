package ananas.blueprint4.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.BPDocumentImplementation;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPTypeRegistrar;
import ananas.lib.io.Connection;
import ananas.lib.io.Connector;
import ananas.lib.io.InputConnection;

public class BPContextWrapper implements BPContext {

	private final BPContext _inner;

	public BPContextWrapper(BPContext inner) {
		this._inner = inner;
	}

	@Override
	public BPTypeRegistrar getTypeRegistrar() {
		return _inner.getTypeRegistrar();
	}

	@Override
	public DocumentBuilderFactory getDOMDocumentBuilderFactory() {
		return _inner.getDOMDocumentBuilderFactory();
	}

	@Override
	public BPDocumentBuilderFactory getBPDocumentBuilderFactory() {
		return _inner.getBPDocumentBuilderFactory();
	}

	@Override
	public BPDocument loadBPDocument(InputStream in, String systemId)
			throws IOException {
		Document dom = this.loadDOMDocument(in, systemId);
		BPDocumentBuilder builder = this.getBPDocumentBuilderFactory()
				.createBuilder();
		return builder.build(this, dom);
	}

	@Override
	public BPDocument loadBPDocument(String systemId) throws IOException {
		return this.loadBPDocument(null, systemId);
	}

	@Override
	public Document loadDOMDocument(String systemId) throws IOException {
		return this.loadDOMDocument(null, systemId);
	}

	@Override
	public Connector getConnector() {
		return this._inner.getConnector();
	}

	@Override
	public Document loadDOMDocument(InputStream in, String systemId)
			throws IOException {

		if (in == null) {
			Connection conn = this.getConnector().open(systemId);
			final InputStream in0 = ((InputConnection) conn).getInputStream();
			byte[] buff = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			for (int cb = in0.read(buff); cb > 0; cb = in0.read(buff)) {
				baos.write(buff, 0, cb);
			}
			in0.close();
			conn.close();
			in = new ByteArrayInputStream(baos.toByteArray());
		}

		try {
			DocumentBuilderFactory domDBF = this.getDOMDocumentBuilderFactory();
			DocumentBuilder domBuilder = domDBF.newDocumentBuilder();
			Document dom = domBuilder.parse(in, systemId);
			return dom;
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public DOMImplementation getDOMImplementation() {
		return this._inner.getDOMImplementation();
	}

	@Override
	public BPDocumentImplementation getBPDocumentImplementation() {
		return this._inner.getBPDocumentImplementation();
	}
}
