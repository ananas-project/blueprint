package ananas.blueprint4.core;

import ananas.lib.util.SingletonLoader;

public interface Blueprint {

	BPEnvironment getEnvironment();

	class Util {

		private static Blueprint _inst;

		public static Blueprint getDefault() {
			Blueprint inst = _inst;
			if (inst == null) {
				_inst = inst = (Blueprint) SingletonLoader
						.load(Blueprint.class);
			}
			return inst;
		}

		public static Blueprint getInstance(String className) {
			return (Blueprint) SingletonLoader.load(className);
		}

	}
}
