package ananas.lib.impl.blueprint.core;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.util.BPBuilder;
import ananas.lib.blueprint.core.util.BPBuilderFactory;

public class BuilderFactoryImpl implements BPBuilderFactory {

	@Override
	public BPBuilder newBuilder(BPDocument doc) {
		return new MyBuilder(doc);
	}

	private class MyBuilder implements BPBuilder {

		private ErrorHandler mErrorHandler;
		private ContentHandler mContentHandler;
		private final BPDocument mDoc;

		public MyBuilder(BPDocument doc) {
			this.mDoc = doc;
		}

		@Override
		public ContentHandler getContentHandler() {
			ContentHandler hdl = this.mContentHandler;
			if (hdl == null) {
				hdl = new MyContentHandler(this);
				this.mContentHandler = hdl;
			}
			return hdl;
		}

		@Override
		public ErrorHandler getErrorHandler() {
			ErrorHandler hdl = this.mErrorHandler;
			if (hdl == null) {
				hdl = new MyErrorHandler(this);
				this.mErrorHandler = hdl;
			}
			return hdl;
		}
	}

	private class MyErrorHandler implements ErrorHandler {

		public MyErrorHandler(MyBuilder myBuilder) {
		}

		@Override
		public void error(SAXParseException e) throws SAXException {
			System.err.println(e);
		}

		@Override
		public void fatalError(SAXParseException e) throws SAXException {
			System.err.println(e);
		}

		@Override
		public void warning(SAXParseException e) throws SAXException {
			System.err.println(e);
		}

	}

	private class MyContentHandler implements ContentHandler {

		private final MyBuilder mBuilder;

		public MyContentHandler(MyBuilder myBuilder) {
			this.mBuilder = myBuilder;
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub

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
			// TODO Auto-generated method stub

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
