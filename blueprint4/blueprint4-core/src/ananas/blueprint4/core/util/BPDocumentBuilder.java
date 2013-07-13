package ananas.blueprint4.core.util;

import org.w3c.dom.Document;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.lang.BPDocument;

public interface BPDocumentBuilder {

	BPDocument build(BPContext context, Document dom);

}
