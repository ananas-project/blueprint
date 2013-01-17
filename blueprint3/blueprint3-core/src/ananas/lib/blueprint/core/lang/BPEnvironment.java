package ananas.lib.blueprint.core.lang;

import ananas.lib.blueprint.core.dom.BPImplementation;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.blueprint.core.util.BPVisitorFactory;
import ananas.lib.blueprint.core.xml.serializer.BPXmlSerializerFactory;
import ananas.lib.io.IConnector;

public interface BPEnvironment {

	BPNamespaceRegistrar getNamespaceRegistrar();

	BPImplementation getImplementation();

	BPXMLReaderFactory getXMLReaderFactory();

	BPXmlSerializerFactory getXmlSerializerFactory();

	BPBuilderFactory getBuilderFactory();

	BPVisitorFactory getVisitorFactory();

	IConnector getConnector();

}
