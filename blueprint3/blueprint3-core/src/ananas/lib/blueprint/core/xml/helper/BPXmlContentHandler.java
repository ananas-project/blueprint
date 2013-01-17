package ananas.lib.blueprint.core.xml.helper;

import ananas.lib.blueprint.core.xml.BPXmlException;

public interface BPXmlContentHandler {

	// Receive notification of character data.
	void characters(char[] ch, int start, int length) throws BPXmlException;

	// Receive notification of the end of a document.
	void endDocument() throws BPXmlException;

	// Receive notification of the end of an element.
	void endElement(String uri, String localName, String qName)
			throws BPXmlException;

	// End the scope of a prefix-URI mapping.
	void endPrefixMapping(String prefix) throws BPXmlException;

	// Receive notification of ignorable whitespace in element content.
	void ignorableWhitespace(char[] ch, int start, int length)
			throws BPXmlException;

	// Receive notification of a processing instruction.
	void processingInstruction(String target, String data)
			throws BPXmlException;

	// Receive an object for locating the origin of SAX document events.
	void setDocumentLocator(BPXmlLocator locator) throws BPXmlException;

	// Receive notification of a skipped entity.
	void skippedEntity(String name) throws BPXmlException;

	// Receive notification of the beginning of a document.
	void startDocument() throws BPXmlException;

	// Receive notification of the beginning of an element.
	void startElement(String uri, String localName, String qName,
			BPXmlAttributes atts) throws BPXmlException;

	// Begin the scope of a prefix-URI Namespace mapping.
	void startPrefixMapping(String prefix, String uri) throws BPXmlException;

}
