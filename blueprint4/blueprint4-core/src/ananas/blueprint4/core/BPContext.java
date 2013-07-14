package ananas.blueprint4.core;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPTypeRegistrar;
import ananas.blueprint4.core.util.BPDocumentBuilderFactory;
import ananas.lib.io.Connector;

public interface BPContext {

	// types
	BPTypeRegistrar getTypeRegistrar();

	// doc builder
	DocumentBuilderFactory getDOMDocumentBuilderFactory();

	BPDocumentBuilderFactory getBPDocumentBuilderFactory();

	DOMImplementation getDOMImplementation();

	BPDocumentImplementation getBPDocumentImplementation();

	// connector
	Connector getConnector();

	// load

	BPDocument loadBPDocument(InputStream in) throws IOException;

	BPDocument loadBPDocument(InputStream in, String systemId)
			throws IOException;

	BPDocument loadBPDocument(String systemId) throws IOException;

	Document loadDOMDocument(String systemId) throws IOException;

	Document loadDOMDocument(InputStream in, String systemId)
			throws IOException;

}
