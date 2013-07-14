package ananas.blueprint4.core.lang;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.BPDocumentImplementation;

public interface BPDocument extends BPNode {

	BPContext getContext();

	BPDocumentImplementation getImplementation();

	BPElement getRootElement();

	BPElement createElement(String uri, String localName);

	BPText createText(String data);
}
