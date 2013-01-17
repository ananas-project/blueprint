package ananas.lib.impl.blueprint.core;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import ananas.lib.blueprint.core.lang.BPXMLReaderFactory;

public class ParserFactoryImpl implements BPXMLReaderFactory {

	@Override
	public XMLReader newReader() throws SAXException {
		String cls = "org.apache.xerces.parsers.SAXParser";
		return XMLReaderFactory.createXMLReader(cls);
	}

}
