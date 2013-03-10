package ananas.lib.impl.blueprint3.core;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import ananas.lib.blueprint3.core.dom.BPDocument;
import ananas.lib.blueprint3.core.lang.BPDocumentLoader;
import ananas.lib.blueprint3.core.lang.BPDocumentLoaderFactory;
import ananas.lib.blueprint3.core.lang.BPEnvironment;
import ananas.lib.blueprint3.core.lang.BlueprintException;
import ananas.lib.blueprint3.core.util.BPBuilder;
import ananas.lib.blueprint3.core.util.BPBuilderFactory;
import ananas.lib.blueprint3.core.util.BPXMLReaderFactory;
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
			BPDocument doc = null;
			Exception ioe = null;

			try {
				conn = (IInputConnection) envi.getConnector().open(uri);
				in = conn.getInputStream();
				doc = this._loadDoc(envi, in, uri);
			} catch (SAXException e) {
				ioe = e;
			} catch (BlueprintException e) {
				ioe = e;
			} catch (IOException e) {
				ioe = e;
			} finally {
				if (in != null) {
					in.close();
				}
				if (conn != null) {
					conn.close();
				}
			}

			if (ioe == null) {
				return doc;

			} else if (ioe instanceof IOException) {
				throw ((IOException) ioe);

			} else if (ioe instanceof BlueprintException) {
				throw ((BlueprintException) ioe);

			} else if (ioe instanceof SAXException) {
				throw ((SAXException) ioe);

			} else {
				throw new RuntimeException(ioe);
			}

		}

		@Override
		public BPDocument loadDocument(BPEnvironment envi, InputStream in,
				String uri) throws IOException, BlueprintException,
				SAXException {

			return this._loadDoc(envi, in, uri);

		}

		private BPDocument _loadDoc(BPEnvironment envi, InputStream in,
				String uri) throws SAXException, IOException {

			BPDocument doc = envi.getImplementation().createDocument(envi, uri);

			BPXMLReaderFactory parserFactory = envi.getXMLReaderFactory();
			XMLReader reader = parserFactory.newReader();
			reader.setFeature("http://xml.org/sax/features/validation", false);
			reader.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-external-dtd",
					false);

			BPBuilderFactory builderFactory = envi.getBuilderFactory();
			BPBuilder builder = builderFactory.newBuilder(doc);

			reader.setContentHandler(builder.getContentHandler());
			reader.setErrorHandler(builder.getErrorHandler());
			reader.parse(new InputSource(in));

			return doc;

		}
	}
}
