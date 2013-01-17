package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.util.BPBuilder;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.blueprint.core.xml.BPXmlException;
import ananas.lib.blueprint.core.xml.helper.BPXmlAttributes;
import ananas.lib.blueprint.core.xml.helper.BPXmlHandler;
import ananas.lib.blueprint.core.xml.helper.BPXmlLocator;

public class BuilderFactoryImpl implements BPBuilderFactory {

	@Override
	public BPBuilder newBuilder(BPDocument doc) {
		return new MyBuilder(doc);
	}

	private class MyBuilder implements BPBuilder {

		private BPXmlHandler mHandler;
		private final BPDocument mDoc;

		public MyBuilder(BPDocument doc) {
			this.mDoc = doc;
		}

		@Override
		public BPXmlHandler getXmlHandler() {
			BPXmlHandler hdl = this.mHandler;
			if (hdl == null) {
				hdl = new MyHandler(this);
				this.mHandler = hdl;
			}
			return hdl;
		}
	}

	private class MyHandler implements BPXmlHandler {

		private final MyBuilder mBuilder;

		public MyHandler(MyBuilder myBuilder) {
			this.mBuilder = myBuilder;
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void endDocument() throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void endPrefixMapping(String prefix) throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void ignorableWhitespace(char[] ch, int start, int length)
				throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void processingInstruction(String target, String data)
				throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setDocumentLocator(BPXmlLocator locator)
				throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void skippedEntity(String name) throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void startDocument() throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void startElement(String uri, String localName, String qName,
				BPXmlAttributes atts) throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void startPrefixMapping(String prefix, String uri)
				throws BPXmlException {
			// TODO Auto-generated method stub

		}

		@Override
		public void error(BPXmlException exception) {
			// TODO Auto-generated method stub

		}

		@Override
		public void fatalError(BPXmlException exception) {
			// TODO Auto-generated method stub

		}

		@Override
		public void warning(BPXmlException exception) {
			// TODO Auto-generated method stub

		}
	}

}
