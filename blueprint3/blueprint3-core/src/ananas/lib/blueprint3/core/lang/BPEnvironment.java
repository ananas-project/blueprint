package ananas.lib.blueprint3.core.lang;

import ananas.lib.blueprint3.core.dom.BPImplementation;
import ananas.lib.blueprint3.core.util.BPBuilderFactory;
import ananas.lib.blueprint3.core.util.BPVisitorFactory;
import ananas.lib.blueprint3.core.util.BPXMLReaderFactory;
import ananas.lib.blueprint3.core.util.nsloader.BPNamespaceInfo;
import ananas.lib.blueprint3.core.util.nsloader.BPNamespaceLoaderFactory;
import ananas.lib.blueprint3.core.xml.serializer.BPXmlSerializerFactory;
import ananas.lib.io.Connector;

public interface BPEnvironment {

	BPNamespaceRegistrar getNamespaceRegistrar();

	BPNamespaceLoaderFactory getNamespaceLoaderFactory();

	BPImplementation getImplementation();

	BPXMLReaderFactory getXMLReaderFactory();

	BPXmlSerializerFactory getXmlSerializerFactory();

	BPDocumentLoaderFactory getDocumentLoaderFactory();

	BPBuilderFactory getBuilderFactory();

	BPVisitorFactory getVisitorFactory();

	Connector getConnector();

	// ns loading

	void loadNamespace(String aClassName, boolean lazy)
			throws BlueprintException;

	void loadNamespace(Class<?> aClass, boolean lazy) throws BlueprintException;

	void loadNamespace(BPNamespaceInfo loader, boolean lazy)
			throws BlueprintException;

}
