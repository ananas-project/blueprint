package ananas.blueprint4.core.namespace;

import java.util.List;

import ananas.blueprint4.core.lang.BPNamespace;
import ananas.blueprint4.core.lang.BPType;
import ananas.blueprint4.core.lang.BPXMLSchema;

public class AbstractBPNamespace implements BPNamespace , NSDefine {

	private final String _propFileName;
	private BPNamespace _impl;

	public AbstractBPNamespace(String propFileName) {
		this._propFileName = propFileName;
	}

	private BPNamespace _getImpl() {
		BPNamespace impl = this._impl;
		if (impl == null) {
			BPNamespaceImplementationFactory f = BPNamespaceImplementationFactory.Agent.getInstance();
			impl = f.createNS(this, this._propFileName);
			this._impl = impl;
		}
		return impl;
	}

	@Override
	public String getURI() {
		return this._getImpl().getURI();
	}

	@Override
	public String getDefaultPrefix() {
		return this._getImpl().getDefaultPrefix();
	}

	@Override
	public List<BPType> listTypes() {
		return this._getImpl().listTypes();
	}

	@Override
	public BPType getType(String localName) {
		return this._getImpl().getType(localName);
	}

	@Override
	public BPXMLSchema getXMLSchema() {
		return this._getImpl().getXMLSchema();
	}

}
