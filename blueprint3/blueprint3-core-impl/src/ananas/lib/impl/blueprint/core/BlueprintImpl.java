package ananas.lib.impl.blueprint.core;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPXMLReaderFactory;
import ananas.lib.blueprint.core.util.BPBuilder;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.io.IInputConnection;

public class BlueprintImpl extends Blueprint {

	private BPEnvironment mDefaultEnvironment;

	@Override
	public BPEnvironment defaultEnvironment() {
		BPEnvironment envi = this.mDefaultEnvironment;
		if (envi == null) {
			envi = new EnvironmentImpl();
			this.mDefaultEnvironment = envi;
		}
		return envi;
	}

	@Override
	public BPDocument loadDocumentByURI(String uri) throws IOException,
			SAXException {

		IInputConnection conn = null;
		InputStream in = null;
		Exception ioe = null;
		BPDocument doc = null;
		try {

			final BPEnvironment envi = this.defaultEnvironment();

			conn = (IInputConnection) envi.getConnector().open(uri);
			in = conn.getInputStream();

			doc = envi.getImplementation().newDocument(envi, uri);

			BPXMLReaderFactory parserFactory = envi.getXMLReaderFactory();
			XMLReader reader = parserFactory.newReader();

			BPBuilderFactory builderFactory = envi.getBuilderFactory();
			BPBuilder builder = builderFactory.newBuilder(doc);

			reader.setContentHandler(builder.getContentHandler());
			reader.setErrorHandler(builder.getErrorHandler());
			reader.parse(new InputSource(in));

		} catch (Exception e) {
			ioe = e;
		}
		if (in != null) {
			in.close();
		}
		if (conn != null) {
			conn.close();
		}
		if (ioe != null) {
			if (ioe instanceof IOException) {
				throw ((IOException) ioe);
			} else if (ioe instanceof SAXException) {
				throw ((SAXException) ioe);
			} else {
				throw new RuntimeException(ioe);
			}
		}
		return doc;
	}

}
