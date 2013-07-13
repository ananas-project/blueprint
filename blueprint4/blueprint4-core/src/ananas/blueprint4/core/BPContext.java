package ananas.blueprint4.core;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPTypeRegistrar;

public interface BPContext {

	BPTypeRegistrar getTypeRegistrar();

	DocumentBuilderFactory getDocumentBuilderFactory();

	BPDocument loadBPDocument(String systemId);

	Document loadDOMDocument(String systemId);

}
