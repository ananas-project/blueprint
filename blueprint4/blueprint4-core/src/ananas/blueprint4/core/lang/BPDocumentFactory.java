package ananas.blueprint4.core.lang;

import ananas.blueprint4.core.BPContext;

public interface BPDocumentFactory {

	BPDocument createDocument(BPContext context, String nsURI, String localName);

}
