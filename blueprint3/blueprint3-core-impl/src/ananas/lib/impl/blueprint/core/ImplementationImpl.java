package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPImplementation;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

public class ImplementationImpl implements BPImplementation {

	@Override
	public BPDocument createDocument(BPEnvironment envi, String uri) {
		return new BpDocumentImpl(envi, uri);
	}

	@Override
	public BPType createType(BPNamespace ns, String localName,
			Class<?> ctrlClass, Class<?> targetClass) {

		return new BPClassImpl(ns, localName, ctrlClass, targetClass);
	}

	@Override
	public BPNamespace createNamespace(BPEnvironment envi, String uri,
			String defaultPrefix) {

		return new BPNamespaceImpl(envi, uri, defaultPrefix);
	}

}
