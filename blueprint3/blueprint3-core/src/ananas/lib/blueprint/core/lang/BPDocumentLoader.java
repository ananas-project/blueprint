package ananas.lib.blueprint.core.lang;

import java.io.IOException;

import org.xml.sax.SAXException;

import ananas.lib.blueprint.core.dom.BPDocument;

public interface BPDocumentLoader {

	BPDocument loadDocument(BPEnvironment envi, String uri) throws IOException,
			SAXException;

}
