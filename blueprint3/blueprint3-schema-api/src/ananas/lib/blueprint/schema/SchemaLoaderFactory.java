package ananas.lib.blueprint.schema;

public abstract class SchemaLoaderFactory {

	public abstract SchemaLoader getLoader();

	public static SchemaLoaderFactory getFactory() {
		return MyInner.__getFactory();
	}

	private static class MyInner {

		static SchemaLoaderFactory s_factory;

		public static SchemaLoaderFactory __getFactory() {
			SchemaLoaderFactory fact = s_factory;
			if (fact == null) {
				fact = MyInner.__createFactory();
				s_factory = fact;
			}
			return fact;
		}

		private static SchemaLoaderFactory __createFactory() {

			String className = "ananas.lib.blueprint.schema.impl.SchemaLoaderFactoryImpl";
			try {
				return (SchemaLoaderFactory) Class.forName(className)
						.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
	}
}
