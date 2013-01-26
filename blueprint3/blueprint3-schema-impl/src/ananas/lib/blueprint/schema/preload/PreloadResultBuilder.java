package ananas.lib.blueprint.schema.preload;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class PreloadResultBuilder implements ContentHandler {

	final Stack<PreloadElement> mStack = new Stack<PreloadElement>();
	private PreloadElement mRoot;
	private PreloadResult mResult;

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endDocument() throws SAXException {

		PreloadResult rlt = new PreloadResult();
		rlt.load(this.mRoot);
		this.mResult = rlt;
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {

		PreloadElement child = this.mStack.pop();
		if (this.mStack.isEmpty()) {
			this.mRoot = child;
		} else {
			PreloadElement parent = this.mStack.peek();
			parent.append(child);
		}
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
		this.mRoot = null;
		this.mStack.clear();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		// System.out.println("" + uri + "#" + localName);
		PreloadClassLibrary lib = PreloadClassLibrary.getInstance();
		PreloadElement ele = lib.createElement(uri, localName);

		for (int i = atts.getLength() - 1; i >= 0; i--) {
			String value = atts.getValue(i);
			String name = atts.getLocalName(i);
			ele.setAttr(name, value);
		}

		this.mStack.push(ele);

	}

	@Override
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	public PreloadResult getResult() {
		return this.mResult;
	}

}
