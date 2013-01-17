package ananas.lib.blueprint.core;

import java.io.IOException;

import org.xml.sax.SAXException;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPEnvironment;

public interface IBlueprint {

	BPEnvironment defaultEnvironment();

	BPDocument loadDocumentByURI(String uri) throws IOException, SAXException;
}
