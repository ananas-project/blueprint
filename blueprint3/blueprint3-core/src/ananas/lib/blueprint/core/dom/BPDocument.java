package ananas.lib.blueprint.core.dom;

import ananas.lib.blueprint.core.lang.BPEnvironment;

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
