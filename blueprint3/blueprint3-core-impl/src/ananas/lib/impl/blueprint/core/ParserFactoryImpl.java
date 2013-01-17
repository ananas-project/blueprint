package ananas.lib.impl.blueprint.core;

import java.io.IOException;
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

import ananas.lib.blueprint.core.xml.BPXmlException;
import ananas.lib.blueprint.core.xml.helper.BPXmlHandler;
import ananas.lib.blueprint.core.xml.parser.BPXmlParser;
import ananas.lib.blueprint.core.xml.parser.BPXmlParserFactory;

public class ParserFactoryImpl implements BPXmlParserFactory {

	@Override
	public BPXmlParser newParser() {
		return new MyParser();
	}

	private class MyParser implements BPXmlParser {

		private XMLReader mReader;

		public MyParser() {
		}

		@Override
		public void parse(InputStream in, BPXmlHandler h) throws IOException,
				BPXmlException {

			try {
				XMLReader rdr = this._getReader();
				MyHandlerProxy hp = new MyHandlerProxy(h);
				rdr.setContentHandler(hp);
				rdr.setErrorHandler(hp);
				rdr.parse(new InputSource(in));
			} catch (SAXException e) {
				throw new BPXmlException(e);
			}
		}

		private XMLReader _getReader() throws SAXException {
			XMLReader rdr = this.mReader;
			if (rdr == null) {
				rdr = XMLReaderFactory
						.createXMLReader("org.apache.xerces.parsers.SAXParser");
				this.mReader = rdr;
			}
			return rdr;
		}

		@Override
		public boolean enableNamespace() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setEnableNamespace(boolean enable) {
			// TODO Auto-generated method stub

		}
	}

	class MyHandlerProxy implements ContentHandler, ErrorHandler {

		private final BPXmlHandler mh;

		public MyHandlerProxy(BPXmlHandler h) {
			this.mh = h;
		}

		@Override
		public void characters(char[] ch , int start , int  length )
				throws SAXException {
			

			try {
				mh.characters(ch, start, length) ;
			} catch (BPXmlException e) {
				 			e.printStackTrace();
			}

		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void endElement(String arg0, String arg1, String arg2)
				throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void endPrefixMapping(String arg0) throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
				throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void processingInstruction(String arg0, String arg1)
				throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setDocumentLocator(Locator arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void skippedEntity(String arg0) throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void startElement(String arg0, String arg1, String arg2,
				Attributes arg3) throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void startPrefixMapping(String arg0, String arg1)
				throws SAXException {
			// TODO Auto-generated method stub

		}

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

}
