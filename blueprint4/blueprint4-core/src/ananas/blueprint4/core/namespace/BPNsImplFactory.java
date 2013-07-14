package ananas.blueprint4.core.namespace;

import ananas.blueprint4.core.lang.BPNamespace;
import ananas.lib.util.SingletonLoader;

public interface BPNsImplFactory {

	String key_ns_scheme = "namespace.scheme";
	String key_ns_types = "namespace.types";

	BPNamespace createNS(Object ref, String propFileName);

	class Agent {

		public static BPNsImplFactory getInstance() {
			return (BPNsImplFactory) SingletonLoader
					.load(BPNsImplFactory.class);
		}
	}
}
