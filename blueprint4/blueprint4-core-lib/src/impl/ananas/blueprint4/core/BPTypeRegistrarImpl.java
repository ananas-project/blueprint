package impl.ananas.blueprint4.core;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import ananas.blueprint4.core.lang.BPNamespace;
import ananas.blueprint4.core.lang.BPType;
import ananas.blueprint4.core.lang.BPTypeRegistrar;
import ananas.lib.util.logging.Logger;

public class BPTypeRegistrarImpl implements BPTypeRegistrar {

	static final Logger log = Logger.Agent.getLogger();

	private final Map<String, String> _mapUriToClass;
	private final Map<String, BPType> _mapNameToType;
	private final Map<String, BPNamespace> _mapUriToNS;

	public BPTypeRegistrarImpl() {
		this._mapUriToClass = new Hashtable<String, String>();
		this._mapUriToNS = new Hashtable<String, BPNamespace>();
		this._mapNameToType = new Hashtable<String, BPType>();
	}

	@Override
	public String getTypeName(String uri, String localName) {
		return (uri + "#" + localName);
	}

	@Override
	public BPType getType(String typeName) {
		return this._mapNameToType.get(typeName);
	}

	@Override
	public BPNamespace getNamespace(String uri) {
		return this._mapUriToNS.get(uri);
	}

	@Override
	public void register(BPType type) {
		String uri = type.getOwnerNamespace().getURI();
		String localName = type.getLocalName();
		String fullname = this.getTypeName(uri, localName);
		this._mapNameToType.put(fullname, type);
	}

	@Override
	public void register(BPNamespace ns) {
		String uri = ns.getURI();
		this._mapUriToNS.put(uri, ns);
		// types
		List<BPType> types = ns.listTypes();
		for (BPType type : types) {
			this.register(type);
		}
	}

	@Override
	public void register(String nsURI, String className) {
		log.info("register blueprint namespace " + nsURI + " -> " + className);
		this._mapUriToClass.put(nsURI, className);
	}

	@Override
	public BPType getType(String uri, String localName) {
		final String name = this.getTypeName(uri, localName);
		BPType type = this.getType(name);
		if (type == null) {
			this._tryLoadNS(uri);
			type = this.getType(name);
		}
		return type;
	}

	private void _tryLoadNS(String uri) {
		String info = "try to load namespace " + uri;
		String className = this._mapUriToClass.get(uri);
		try {
			if (className != null) {
				Class<?> aClass = Class.forName(className);
				BPNamespace ns = (BPNamespace) aClass.newInstance();
				this.register(ns);
				log.info(info + " ... [success]");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(info + " ... [failed]");
	}
}
