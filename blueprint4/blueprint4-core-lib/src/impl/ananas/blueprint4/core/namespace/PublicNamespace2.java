package impl.ananas.blueprint4.core.namespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPElement;
import ananas.blueprint4.core.lang.BPNamespace;
import ananas.blueprint4.core.lang.BPType;
import ananas.blueprint4.core.lang.BPXMLSchema;
import ananas.lib.util.logging.Logger;

public class PublicNamespace2 implements BPNamespace {

	static final Logger log = Logger.Agent.getLogger();

	final static String ns_uri = "ananas:blueprint4:namespace";
	final static String default_prefix = "bp4ns";

	private final Map<String, BPType> _types;

	public PublicNamespace2() {
		this._types = new Hashtable<String, BPType>();
		this._regTypes();
	}

	private void _regTypes() {
		this._regType("namespace");
		this._regType("head");
		this._regType("body");
		this._regType("element");
		this._regType("property");
	}

	private void _regType(String localName) {
		try {
			String pkg = this.getClass().getPackage().getName();
			final String tar = ".Tar_";
			final String ctr = ".Ctr_";
			Class<?> classTar = Class.forName(pkg + tar + localName);
			Class<?> classCtr = Class.forName(pkg + ctr + localName);

			MyType type = new MyType();
			type._localName = localName;
			type._controllerClass = classCtr;
			type._targetClass = classTar;
			this._types.put(localName, type);

		} catch (Exception e) {
			log.error(e);
		}
	}

	@Override
	public String getURI() {
		return ns_uri;
	}

	@Override
	public String getDefaultPrefix() {
		return default_prefix;
	}

	@Override
	public List<BPType> listTypes() {
		Collection<BPType> all = this._types.values();
		return new ArrayList<BPType>(all);
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

	class MyType implements BPType {

		private Class<?> _targetClass;
		private Class<?> _controllerClass;
		private String _localName;

		@Override
		public BPNamespace getOwnerNamespace() {
			return PublicNamespace2.this;
		}

		@Override
		public String getLocalName() {
			return this._localName;
		}

		@Override
		public Class<?> getControllerClass() {
			return this._controllerClass;
		}

		@Override
		public Class<?> getTargetClass() {
			return this._targetClass;
		}

		@Override
		public BPElement createController(BPDocument doc) {
			try {
				BPElement ctrl = (BPElement) this._controllerClass
						.newInstance();
				ctrl.bind(doc);
				ctrl.bind(this);
				return ctrl;
			} catch (Exception e) {
				log.error(e);
				return null;
			}
		}
	}

}
