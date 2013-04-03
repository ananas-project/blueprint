package ananas.lib.blueprint3.core.dom;

import java.net.URI;

import ananas.lib.blueprint3.core.lang.BPEnvironment;
import ananas.lib.blueprint3.core.lang.BPNamespace;
import ananas.lib.blueprint3.core.lang.BPType;

public interface BPImplementation {

	BPDocumentGroup createDocumentGroup(BPEnvironment envi);

	BPDocument createDocument(BPDocumentGroup onwerGroup, URI uri);

	BPNamespace createNamespace(BPEnvironment envi, String uri,
			String defaultPrefix);

	BPType createType(BPNamespace ns, String localName, Class<?> ctrlClass,
			Class<?> targetClass);

}
