package ananas.lib.impl.blueprint.core;

import java.util.HashMap;
import java.util.Map;

import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPNamespaceRegistrar;

public class NamespaceRegImpl implements BPNamespaceRegistrar {

	private final Map<String, BPNamespace> mNsTable;

	public NamespaceRegImpl() {
		this.mNsTable = new HashMap<String, BPNamespace>();
	}

	@Override
	public boolean registerNamespace(BPNamespace ns) {

		System.out.println("reg package : " + ns.getNamespaceURI());

		String uri = ns.getNamespaceURI();
		this.mNsTable.put(uri, ns);
		return true;
	}

	@Override
	public boolean unregisterNamespace(BPNamespace pkg) {
		String uri = pkg.getNamespaceURI();
		this.mNsTable.remove(uri);
		return true;
	}

	@Override
	public BPNamespace getNamespace(String nsURI) {
		return this.mNsTable.get(nsURI);
	}

}
