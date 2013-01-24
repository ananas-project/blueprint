package ananas.lib.blueprint.core.util;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public interface BPXMLReaderFactory {

	XMLReader newReader() throws SAXException;

}
