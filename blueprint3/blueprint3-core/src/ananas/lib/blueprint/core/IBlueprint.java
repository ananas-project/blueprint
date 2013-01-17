package ananas.lib.blueprint.core;

import java.io.IOException;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.xml.BPXmlException;

public interface IBlueprint {

	BPEnvironment defaultEnvironment();

	BPDocument loadDocumentByURI(String uri) throws IOException, BPXmlException;
}
