package ananas.lib.blueprint3.core.dom;

import ananas.lib.blueprint3.core.lang.BPEnvironment;
import ananas.lib.blueprint3.core.lang.BPNamespace;
import ananas.lib.blueprint3.core.lang.BPType;

public interface BPImplementation {

	BPDocument createDocument(BPEnvironment envi, String uri);

	BPNamespace createNamespace(BPEnvironment envi, String uri,
			String defaultPrefix);

	BPType createType(BPNamespace ns, String localName, Class<?> ctrlClass,
			Class<?> targetClass);

}
