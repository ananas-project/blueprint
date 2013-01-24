package ananas.lib.blueprint.core.dom;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

public interface BPImplementation {

	BPDocument createDocument(BPEnvironment envi, String uri);

	BPNamespace createPackage(BPEnvironment envi, String uri,
			String defaultPrefix);

	BPType createBPClass(BPNamespace ns, String localName, Class<?> ctrlClass,
			Class<?> targetClass);

}
