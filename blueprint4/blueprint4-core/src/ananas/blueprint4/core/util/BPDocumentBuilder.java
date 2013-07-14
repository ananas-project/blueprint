package ananas.blueprint4.core.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPElement;

public interface BPDocumentBuilder {

	BPDocument build(BPContext context, Document dom);

	BPElement build(BPContext context, Element dom);

}
