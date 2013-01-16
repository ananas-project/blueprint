package ananas.lib.impl.blueprint.core;

import java.io.IOException;
import java.io.InputStream;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.util.BPBuilder;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.blueprint.core.util.xmlhelper.BPXmlHandler;
import ananas.lib.blueprint.core.util.xmlparser.BPXmlParser;
import ananas.lib.blueprint.core.util.xmlparser.BPXmlParserFactory;
import ananas.lib.io.IInputConnection;

public class BlueprintImpl extends Blueprint {

	private BPEnvironment mDefaultEnvironment;

	@Override
	public BPEnvironment defaultEnvironment() {
		BPEnvironment envi = this.mDefaultEnvironment;
		if (envi == null) {
			envi = new BPEnvironmentImpl();
			this.mDefaultEnvironment = envi;
		}
		return envi;
	}

	@Override
	public BPDocument loadDocumentByURI(String uri) throws IOException {
		IInputConnection conn = null;
		InputStream in = null;
		IOException ioe = null;
		BPDocument doc = null;
		try {

			final BPEnvironment envi = this.defaultEnvironment();

			conn = (IInputConnection) envi.getConnector().open(uri);
			in = conn.getInputStream();

			doc = envi.getImplementation().newDocument(envi, uri);

			BPXmlParserFactory parserFactory = envi.getXmlParserFactory();
			BPXmlParser parser = parserFactory.newParser();

			BPBuilderFactory builderFactory = envi.getBuilderFactory();
			BPBuilder builder = builderFactory.newBuilder(doc);

			BPXmlHandler hdr = builder.getXmlHandler();
			parser.parse(in, hdr);

		} catch (IOException e) {
			ioe = e;
		}
		if (in != null) {
			in.close();
		}
		if (conn != null) {
			conn.close();
		}
		if (ioe != null) {
			throw ioe;
		}
		return doc;
	}

}
