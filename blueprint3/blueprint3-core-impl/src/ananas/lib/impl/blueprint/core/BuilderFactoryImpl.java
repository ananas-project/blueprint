package ananas.lib.impl.blueprint.core;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;
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
		private final BPDocument mDoc;

		private final Stack<BPElement> mStack = new Stack<BPElement>();

		public MyContentHandler(MyBuilder myBuilder) {
			this.mBuilder = myBuilder;
			this.mDoc = this.mBuilder.mDoc;
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub

		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub

			this.mDoc.appendChild(null);

		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {

			final BPElement child = this.mStack.pop();
			final BPElement parent;
			if (this.mStack.isEmpty()) {
				parent = null;
			} else {
				parent = this.mStack.peek();
			}

			child.setParent(parent);

			child.tagEnd();

			if (parent == null) {
				this.mDoc.appendChild(child);
			} else {
				parent.appendChild(child);
			}
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

			// System.out.println(this + ".startElement:" + qName);

			BPElement element = this.mDoc.createElement(uri, localName);
			if (element == null) {
				SAXException e = this._newException("no element", uri,
						localName);
				throw e;
			}
			this.mStack.push(element);

			final int cntAttr = atts.getLength();
			for (int i = 0; i < cntAttr; i++) {
				String attrURI = atts.getURI(i);
				String attrLName = atts.getLocalName(i);
				String attrValue = atts.getValue(i);

				if (attrURI != null) {
					if (attrURI.isEmpty()) {
						attrURI = null;
					}
				}
				attrURI = uri;

				BPAttribute attr = this.mDoc.createAttribute(element, attrURI,
						attrLName, attrValue);

				if (attr == null) {
					SAXException e = this._newException("no attr", attrURI,
							attrLName);
					throw e;
				}

				boolean rlt = element.setAttribute(attr);
				rlt=true;
				if (!rlt) {
					String msg = "element no accept attr";
					System.err.println(msg);
					System.err.println("    eleemnt: " + uri + "#" + localName);
					System.err.println("       attr: " + attrURI + "#"
							+ attrLName);
					SAXException e = this
							._newException(msg, attrURI, attrLName);
					throw e;
				}
			}

			element.tagBegin();

		}

		private SAXException _newException(String msg, String uri,
				String localName) {

			String str = msg + " : " + uri + "#" + localName;
			return new SAXException(str);
		}

		@Override
		public void startPrefixMapping(String prefix, String uri)
				throws SAXException {
			// TODO Auto-generated method stub

		}

	}

}
