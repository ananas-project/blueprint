package ananas.lib.blueprint3.core.dom;

import ananas.lib.blueprint3.core.lang.BPEnvironment;

public interface BPDocument extends BPNode {

	BPElement getRootElement();

	String getDocumentURI();

	BPEnvironment getEnvironment();

	BPText createText(String data);

	BPAttribute createAttribute(String uri, String localName, String value);

	BPElement createElement(String uri, String localName);

	BPElement findElementById(String id);

	BPElement findElementByURI(String uri);

	Object findTargetById(String id);

	Object findTargetByURI(String uri);

	BPElementMap getElementRegistrar();

	void setElementRegistrar(BPElementMap reg);

}
