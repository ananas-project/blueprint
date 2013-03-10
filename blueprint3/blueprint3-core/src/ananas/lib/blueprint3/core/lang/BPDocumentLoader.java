package ananas.lib.blueprint3.core.lang;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;

import ananas.lib.blueprint3.core.dom.BPDocument;

public interface BPDocumentLoader {

	BPDocument loadDocument(BPEnvironment envi, String uri) throws IOException,
			BlueprintException, SAXException;

	BPDocument loadDocument(BPEnvironment envi, InputStream in, String uri)
			throws IOException, BlueprintException, SAXException;

}
