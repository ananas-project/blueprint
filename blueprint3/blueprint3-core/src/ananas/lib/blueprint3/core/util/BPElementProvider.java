package ananas.lib.blueprint3.core.util;

import ananas.lib.blueprint3.core.dom.BPDocument;
import ananas.lib.blueprint3.core.dom.BPElement;

public interface BPElementProvider {

	BPElement createElement(BPDocument doc, String uri, String localName);

}
