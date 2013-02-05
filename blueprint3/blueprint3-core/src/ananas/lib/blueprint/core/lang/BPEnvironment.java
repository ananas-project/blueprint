package ananas.lib.blueprint.core.lang;

import ananas.lib.blueprint.core.dom.BPImplementation;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.blueprint.core.util.BPVisitorFactory;
import ananas.lib.blueprint.core.util.BPXMLReaderFactory;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceInfo;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceLoaderFactory;
import ananas.lib.blueprint.core.xml.serializer.BPXmlSerializerFactory;
import ananas.lib.io.IConnector;

public interface BPEnvironment {

	BPNamespaceRegistrar getNamespaceRegistrar();

	BPNamespaceLoaderFactory getNamespaceLoaderFactory();

	BPImplementation getImplementation();

	BPXMLReaderFactory getXMLReaderFactory();

	BPXmlSerializerFactory getXmlSerializerFactory();

	BPDocumentLoaderFactory getDocumentLoaderFactory();

	BPBuilderFactory getBuilderFactory();

	BPVisitorFactory getVisitorFactory();

	IConnector getConnector();

	// ns loading

	void loadNamespace(String aClassName, boolean lazy)
			throws BlueprintException;

	void loadNamespace(Class<?> aClass, boolean lazy) throws BlueprintException;

	void loadNamespace(BPNamespaceInfo loader, boolean lazy)
			throws BlueprintException;

}
