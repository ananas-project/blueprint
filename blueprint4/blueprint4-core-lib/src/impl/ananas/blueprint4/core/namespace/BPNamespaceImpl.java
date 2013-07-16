package impl.ananas.blueprint4.core.namespace;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import ananas.blueprint4.core.lang.BPNamespace;
import ananas.blueprint4.core.lang.BPType;
import ananas.blueprint4.core.lang.BPXMLSchema;

class BPNamespaceImpl implements BPNamespace {

	public static class Context {

		public String defaultPrefix;
		public String namespaceURI;

	}

	private final Map<String, BPType> _types;
	private final String _namespaceURI;
	private final String _defaultPrefix;

	public BPNamespaceImpl(Context context) {
		this._types = new Hashtable<String, BPType>();
		this._defaultPrefix = context.defaultPrefix;
		this._namespaceURI = context.namespaceURI;
	}

	@Override
	public String getURI() {
		return this._namespaceURI;
	}

	@Override
	public String getDefaultPrefix() {
		return this._defaultPrefix;
	}

	@Override
	public List<BPType> listTypes() {
		return new ArrayList<BPType>(this._types.values());
	}

	@Override
	public BPType getType(String localName) {
		return this._types.get(localName);
	}

	@Override
	public BPXMLSchema getXMLSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTypes(List<BPType> types) {
		for (BPType type : types) {
			if (type.getOwnerNamespace().equals(this)) {
				this._types.put(type.getLocalName(), type);
			}
		}
	}

}
