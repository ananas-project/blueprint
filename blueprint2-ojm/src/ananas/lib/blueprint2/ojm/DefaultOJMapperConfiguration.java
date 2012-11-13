package ananas.lib.blueprint2.ojm;

public class DefaultOJMapperConfiguration implements OJMapperConfiguration {

	private OJMapperConfiguration target;

	@Override
	public OJMapperFactory getMapperFactory() {
		OJMapperConfiguration t = this.target;
		if (t == null) {
			try {
				String className = "ananas.lib.blueprint2.ojm.impl.DefaultOJMapperConfigurationImpl";
				Class<?> cls = Class.forName(className);
				t = (OJMapperConfiguration) cls.newInstance();
				this.target = t;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return t.getMapperFactory();
	}

}
