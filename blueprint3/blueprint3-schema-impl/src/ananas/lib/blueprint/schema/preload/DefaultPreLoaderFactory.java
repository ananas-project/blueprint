package ananas.lib.blueprint.schema.preload;

public class DefaultPreLoaderFactory implements IPreLoaderFactory {

	@Override
	public IPreLoader newLoader() {
		return new DefaultPreLoader();
	}

}
