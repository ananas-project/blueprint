package ananas.lib.impl.blueprint.core;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPDocumentLoader;
import ananas.lib.blueprint.core.lang.BPDocumentLoaderFactory;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.util.BPBuilder;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.blueprint.core.util.BPXMLReaderFactory;
import ananas.lib.io.IInputConnection;

public class DocLoaderFactoryImpl implements BPDocumentLoaderFactory {

	@Override
	public BPDocumentLoader newLoader() {
		return new MyLoader();
	}

	class MyLoader implements BPDocumentLoader {

		@Override
		public BPDocument loadDocument(BPEnvironment envi, String uri)
				throws IOException, SAXException {

			IInputConnection conn = null;
			InputStream in = null;
			Exception ioe = null;
			BPDocument doc = null;
			try {

				conn = (IInputConnection) envi.getConnector().open(uri);
				in = conn.getInputStream();

				doc = envi.getImplementation().createDocument(envi, uri);

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
}
