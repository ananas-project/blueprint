package test.xmlparser;

import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class TestXmlParser implements Runnable {

	public static void main(String[] arg) {
		(new TestXmlParser()).run();
	}

	@Override
	public void run() {

		System.out.println(this + ".begin");

		try {

			InputStream is = this.getClass().getResourceAsStream("test.xml");
			XMLReader rdr = XMLReaderFactory
					.createXMLReader("ananas.lib.blueprint.xmlparser.SAXParser");

			rdr.setContentHandler(new MyContentHandler());
			rdr.setErrorHandler(new MyErrorHandler());

			rdr.parse(new InputSource(is));

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(this + ".end");

	}

	class MyErrorHandler implements ErrorHandler {

		@Override
		public void error(SAXParseException arg0) throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void fatalError(SAXParseException arg0) throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void warning(SAXParseException arg0) throws SAXException {
			// TODO Auto-generated method stub

		}
	}

	class MyContentHandler implements ContentHandler {

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {

			System.out.println(this + ".Char:" + new String(ch, start, length));

		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println(this + ".endDocument");

		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {

			System.out.println(this + ".endElement:" + qName);
		}

		@Override
		public void endPrefixMapping(String prefix) throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void ignorableWhitespace(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void processingInstruction(String target, String data)
				throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setDocumentLocator(Locator locator) {
			// TODO Auto-generated method stub

		}

		@Override
		public void skippedEntity(String name) throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void startDocument() throws SAXException {
			System.out.println(this + ".startDocument");
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes atts) throws SAXException {

			System.out.println(this + ".startElement:" + qName);
		}

		@Override
		public void startPrefixMapping(String prefix, String uri)
				throws SAXException {
			// TODO Auto-generated method stub

		}
	}
}
