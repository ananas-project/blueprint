package ananas.lib.blueprint.schema;

import java.io.IOException;

import org.xml.sax.SAXException;

import ananas.lib.blueprint.core.lang.BPEnvironment;

public interface SchemaLoader {

	void load(BPEnvironment envi, String infoClass) throws SchemaException;

	void load(BPEnvironment envi, Class<?> infoClass) throws SchemaException;

	void load(BPEnvironment envi, SchemaInfo info) throws SchemaException,
			SAXException, IOException;

}
