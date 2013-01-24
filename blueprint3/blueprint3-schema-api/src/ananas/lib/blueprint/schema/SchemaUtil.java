package ananas.lib.blueprint.schema;

import ananas.lib.blueprint.core.lang.BPEnvironment;

public abstract class SchemaUtil {

	public static void loadScheme(BPEnvironment envi, String infoClass)
			throws SchemaException {

		SchemaLoader ldr = SchemaLoaderFactory.getFactory().getLoader();
		ldr.load(envi, infoClass);
	}

	public static void loadScheme(BPEnvironment envi, Class<?> infoClass)
			throws SchemaException {

		SchemaLoader ldr = SchemaLoaderFactory.getFactory().getLoader();
		ldr.load(envi, infoClass);
	}

}
