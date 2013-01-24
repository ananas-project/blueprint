package ananas.lib.blueprint.schema.impl;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.util.BPBuilder;
import ananas.lib.blueprint.schema.SchemaInfo;

public class FinalSchemaLoader {

	private final SchemaInfo mInfo;
	private final BPEnvironment mEnvi;

	public FinalSchemaLoader(BPEnvironment envi, SchemaInfo info) {
		this.mInfo = info;
		this.mEnvi = envi;
	}

	public void load() throws SAXException, IOException {

		SchemaInfo info = this.mInfo;
		BPEnvironment envi = this.mEnvi;
		{
			// mapping
			InputStream is = this._getInput(info,
					info.getClassMappingFileName());
			BPDocument doc = this._loadDocument(envi, this + ".mapping", is);
			BPElement root = doc.getRootElement();
		}
		{
			// xsd
			InputStream is = this._getInput(info, info.getXsdFileName());
			BPDocument doc = this._loadDocument(envi, this + ".xsd", is);
			BPElement root = doc.getRootElement();
		}

	}

	private BPDocument _loadDocument(BPEnvironment envi, String uri,
			InputStream in) throws SAXException, IOException {

		BPDocument doc = envi.getImplementation().createDocument(envi, uri);
		BPBuilder bdr = envi.getBuilderFactory().newBuilder(doc);
		XMLReader rdr = envi.getXMLReaderFactory().newReader();

		rdr.setErrorHandler(bdr.getErrorHandler());
		rdr.setContentHandler(bdr.getContentHandler());
		rdr.setDTDHandler(new MyDTDHandler());

		rdr.setFeature("http://xml.org/sax/features/validation", false);
		rdr.setFeature(
				"http://apache.org/xml/features/nonvalidating/load-external-dtd",
				false);

		rdr.parse(new InputSource(in));
		return doc;
	}

	private InputStream _getInput(Object classpath, String fileName) {
		Class<?> cls = classpath.getClass();
		InputStream in = cls.getResourceAsStream(fileName);
		if (in == null) {
			throw new RuntimeException("cannot get res stream for"
					+ cls.getName() + "#" + fileName);
		}
		return in;
	}

}
