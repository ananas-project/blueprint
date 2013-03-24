package ananas.lib.blueprint3.loader.eom;

import ananas.lib.blueprint3.core.Blueprint;

public class EOM {

	public static void init() {
		Class<?> cls = EomReflectInfo.class;
		Blueprint.getInstance().defaultEnvironment().loadNamespace(cls, true);
	}

}
