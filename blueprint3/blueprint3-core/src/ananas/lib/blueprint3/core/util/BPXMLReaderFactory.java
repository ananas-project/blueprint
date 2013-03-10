package ananas.lib.blueprint3.core.util;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public interface BPXMLReaderFactory {

	XMLReader newReader() throws SAXException;

}
