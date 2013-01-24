package ananas.lib.blueprint.schema.impl;

import ananas.lib.blueprint.schema.SchemaLoader;
import ananas.lib.blueprint.schema.SchemaLoaderFactory;

public class SchemaLoaderFactoryImpl extends SchemaLoaderFactory {

	@Override
	public SchemaLoader getLoader() {
		return new SchemaLoaderImpl();
	}

}
