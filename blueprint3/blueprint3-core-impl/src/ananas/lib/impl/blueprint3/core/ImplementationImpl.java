package ananas.lib.impl.blueprint3.core;

import ananas.lib.blueprint3.core.dom.BPDocument;
import ananas.lib.blueprint3.core.dom.BPImplementation;
import ananas.lib.blueprint3.core.lang.BPEnvironment;
import ananas.lib.blueprint3.core.lang.BPNamespace;
import ananas.lib.blueprint3.core.lang.BPType;

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
