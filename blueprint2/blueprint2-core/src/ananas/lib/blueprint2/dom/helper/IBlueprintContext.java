package ananas.lib.blueprint2.dom.helper;

import ananas.lib.io.Connector;

public interface IBlueprintContext {

	Connector getConnector();

	IImplementation getImplementation();

	IDocumentBuilderFactory getDocumentBuilderFactory();

	IDocumentSerializerFactory getDocumentSerializerFactory();

}
