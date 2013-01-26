package ananas.lib.blueprint.schema.preload;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;

class DefaultPreLoader implements IPreLoader {

	@Override
	public BPNamespace loadNamespace(BPEnvironment envi, Object classpath,
			String xmlFileName) throws SAXException, IOException {

		InputSource in = this._getInputStream(classpath, xmlFileName);
		XMLReader rdr = envi.getXMLReaderFactory().newReader();
		PreloadResultBuilder builder = new PreloadResultBuilder();
		rdr.setContentHandler(builder);
		rdr.parse(in);

		PreloadResult result = builder.getResult();
		String nsuri = result.getNamespaceURI();
		String defaultPrefix = result.getDefaultPrefix();
		BPNamespace ns = envi.getImplementation().createNamespace(envi, nsuri,
				defaultPrefix);

		result.regClassesToNamespace(ns);

		return ns;

	}

	private InputSource _getInputStream(Object classpath, String xmlFileName) {
		InputStream in = classpath.getClass().getResourceAsStream(xmlFileName);
		return new InputSource(in);
	}

}
