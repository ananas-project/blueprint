package impl.ananas.blueprint4.core;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import ananas.blueprint4.core.BPEnvironment;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPTypeRegistrar;
import ananas.blueprint4.core.util.BPContextWrapper;
import ananas.blueprint4.core.util.BPDocumentBuilderFactory;
import ananas.lib.io.Connector;

public class BPEnvironmentImpl implements BPEnvironment {

	private BPContextWrapper _wrapper;
	private Connector _connector;

	@Override
	public BPTypeRegistrar getTypeRegistrar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentBuilderFactory getDOMDocumentBuilderFactory() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		return dbf;
	}

	@Override
	public BPDocumentBuilderFactory getBPDocumentBuilderFactory() {
		return BPDocumentBuilderFactory.Agent.getDefault();
	}

	@Override
	public BPDocument loadBPDocument(InputStream in, String systemId)
			throws IOException {
		BPContextWrapper wrapper = this._getMyWrapper();
		return wrapper.loadBPDocument(in, systemId);
	}

	private BPContextWrapper _getMyWrapper() {
		BPContextWrapper wp = _wrapper;
		if (wp == null) {
			_wrapper = wp = new BPContextWrapper(this);
		}
		return wp;
	}

	@Override
	public BPDocument loadBPDocument(String systemId) throws IOException {
		BPContextWrapper wrapper = this._getMyWrapper();
		return wrapper.loadBPDocument(systemId);
	}

	@Override
	public Document loadDOMDocument(String systemId) throws IOException {
		BPContextWrapper wrapper = this._getMyWrapper();
		return wrapper.loadDOMDocument(systemId);
	}

	@Override
	public Connector getConnector() {
		Connector conn = this._connector;
		if (conn == null) {
			conn = Connector.Factory.getDefault();
			this._connector = conn;
		}
		return conn;
	}

	@Override
	public Document loadDOMDocument(InputStream in, String systemId)
			throws IOException {
		BPContextWrapper wrapper = this._getMyWrapper();
		return wrapper.loadDOMDocument(in, systemId);
	}

}
