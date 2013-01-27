package ananas.lib.blueprint.core.util;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;

public interface BPElementProvider {

	BPElement createElement(BPDocument doc, String uri, String localName);

}
