package ananas.lib.blueprint.core.lang;

import ananas.lib.blueprint.core.dom.BPImplementation;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.blueprint.core.util.BPVisitorFactory;
import ananas.lib.blueprint.core.util.BPXmlParserFactory;
import ananas.lib.blueprint.core.util.BPXmlSerializerFactory;

public interface BPEnvironment {

	BPNamespaceRegistrar getNamespaceRegistrar();

	BPImplementation getImplementation();

	BPXmlParserFactory getXmlParserFactory();

	BPXmlSerializerFactory getXmlSerializerFactory();

	BPBuilderFactory getBuilderFactory();

	BPVisitorFactory getVisitorFactory();

}
