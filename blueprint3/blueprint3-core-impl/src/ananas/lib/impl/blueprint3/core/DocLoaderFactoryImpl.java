package ananas.lib.impl.blueprint3.core;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import ananas.lib.blueprint3.dom.BPDocument;
import ananas.lib.blueprint3.dom.BPDocumentGroup;
import ananas.lib.blueprint3.lang.BPDocumentLoader;
import ananas.lib.blueprint3.lang.BPDocumentLoaderFactory;
import ananas.lib.blueprint3.lang.BPEnvironment;
import ananas.lib.blueprint3.lang.BlueprintException;
import ananas.lib.blueprint3.util.BPBuilder;
import ananas.lib.blueprint3.util.BPBuilderFactory;
import ananas.lib.blueprint3.util.BPXMLReaderFactory;
import ananas.lib.io.InputConnection;

public class DocLoaderFactoryImpl implements BPDocumentLoaderFactory {

	private class MyLoader implements BPDocumentLoader {

		private final BPEnvironment mEnvi;

		public MyLoader(BPEnvironment envi) {
			this.mEnvi = envi;
		}

		

		private BPDocument _loadDoc(InputStream in, String uri)
				throws SAXException, IOException {

			BPEnvironment envi = null;
			BPDocumentGroup onwerGroup = null;
			BPDocument doc = null;// envi.getImplementation().createDocument(onwerGroup, uri) ;

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

	 
	 
	 
		@Override
		public void loadDocument(BPDocument doc) throws IOException {
			// TODO Auto-generated method stub

		}

		@Override
		public void loadDocument(BPDocument doc, InputStream in)
				throws IOException {
			// TODO Auto-generated method stub

		}
	}

	@Override
	public BPDocumentLoader newLoader() {
		// return new MyLoader(envi);
		throw new RuntimeException("this class is out of use!");
	}
}
