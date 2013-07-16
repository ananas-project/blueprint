package impl.ananas.blueprint4.core.namespace;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPNamespace;
import ananas.blueprint4.core.lang.BPType;
import ananas.blueprint4.core.namespace.NSDefine;
import ananas.lib.util.logging.Logger;

class PrivateNamespaceBuilder {

	final static Logger log = Logger.Agent.getLogger();

	private MyProper _prop;
	private List<Tar_element> _elements;

	public BPNamespace buildNamespace() {
		List<BPType> map = new ArrayList<BPType>();
		BPNamespaceImpl.Context cont = new BPNamespaceImpl.Context();
		cont.defaultPrefix = _prop.getNSDefaultPrefix();
		cont.namespaceURI = _prop.getNSURI();
		BPNamespaceImpl ns = new BPNamespaceImpl(cont);
		for (Tar_element element : this._elements) {
			MyTypeBuilder tb = new MyTypeBuilder(ns, element, this._prop);
			BPType type = tb.createType();
			map.add(type);
		}
		ns.addTypes(map);
		return ns;
	}

	public void setTypesDocument(BPDocument doc) {
		// get properties
		Tar_namespace ns = (Tar_namespace) doc.getRootElement().getTarget(true);
		Properties prop0 = ns.getHead().getProperties();
		MyProper prop = new MyProper(prop0);
		this._prop = prop;
		// get types
		List<Tar_element> elements = ns.getBody().listElements();
		this._elements = elements;
	}

	public void setSchemeInputSource(PrivateInputSource source) {
		// TODO Auto-generated method stub

	}

	private class MyTypeBuilder {

		private final BPNamespaceImpl _ns;
		private final Tar_element _element;
		private final MyProper _prop;

		public MyTypeBuilder(BPNamespaceImpl ns, Tar_element element,
				MyProper prop) {
			this._ns = ns;
			this._prop = prop;
			this._element = element;
		}

		public BPType createType() {
			String lname = this.getLocalName();
			Class<?> classC = this.findClassC();
			Class<?> classT = this.findClassT();
			return new BPTypeImpl(_ns, lname, classC, classT);
		}

		private Class<?> findClassT() {
			String name = this._element.getTargetName();
			String pkg = this._prop.getTargetPackage();
			String prefix = this._prop.getTargetPrefix();
			String suffix = this._prop.getTargetSuffix();
			return this.findClass(pkg, prefix, name, suffix);
		}

		private Class<?> findClass(String packageName, String prefix,
				String midName, String suffix) {
			if (prefix == null)
				prefix = "";
			if (suffix == null)
				suffix = "";
			final String localName = this.getLocalName();
			final String fullname;
			if (midName == null) {
				// gen by localName
				fullname = packageName + "." + prefix + localName + suffix;
			} else if (midName.startsWith(".")) {
				// .xxx
				fullname = packageName + midName;
			} else {
				// xxx.xxx.xxx
				fullname = midName;
			}
			// normalize full name
			StringBuilder sb = new StringBuilder();
			char[] chs = fullname.toCharArray();
			for (char ch : chs) {
				if (ch == ' ' || ch == 0x09 || ch == 0x0a || ch == 0x0d) {
					// skip
				} else if ('0' <= ch && ch <= '9') {
					sb.append(ch);
				} else if ('a' <= ch && ch <= 'z') {
					sb.append(ch);
				} else if ('A' <= ch && ch <= 'Z') {
					sb.append(ch);
				} else if (ch == '.') {
					sb.append('.');
				} else {
					sb.append('_');
				}
			}
			// get class
			try {
				return Class.forName(sb.toString());
			} catch (ClassNotFoundException e) {
				log.error(e);
				return null;
			}
		}

		private Class<?> findClassC() {
			String name = this._element.getControllerName();
			String pkg = this._prop.getCtrlPackage();
			String prefix = this._prop.getCtrlPrefix();
			String suffix = this._prop.getCtrlSuffix();
			return this.findClass(pkg, prefix, name, suffix);
		}

		public String getLocalName() {
			return this._element.getLocalName();
		}
	}

	private class MyProper {

		private final Properties _prop;

		private final String _target_package;
		private final String _target_suffix;
		private final String _target_prefix;

		private final String _ctrl_package;
		private final String _ctrl_suffix;
		private final String _ctrl_prefix;

		private final String _ns_uri;
		private final String _ns_default_prefix;

		public MyProper(Properties prop) {
			this._prop = prop;

			this._ctrl_package = this.getString(NSDefine.key_ctrl_package);
			this._ctrl_prefix = this.getString(NSDefine.key_ctrl_prefix);
			this._ctrl_suffix = this.getString(NSDefine.key_ctrl_suffix);

			this._target_package = this.getString(NSDefine.key_target_package);
			this._target_prefix = this.getString(NSDefine.key_target_prefix);
			this._target_suffix = this.getString(NSDefine.key_target_suffix);

			this._ns_uri = this.getString(NSDefine.key_ns_uri);
			this._ns_default_prefix = this
					.getString(NSDefine.key_ns_default_prefix);
		}

		private String getString(String key) {
			String value = this._prop.getProperty(key);
			if (value == null) {
				log.warn(this + ".needForPropertyKey:" + key);
			}
			return value;
		}

		public String getTargetPrefix() {
			return this._target_prefix;
		}

		public String getTargetSuffix() {
			return this._target_suffix;
		}

		public String getTargetPackage() {
			return this._target_package;
		}

		public String getCtrlPrefix() {
			return this._ctrl_prefix;
		}

		public String getCtrlSuffix() {
			return this._ctrl_suffix;
		}

		public String getCtrlPackage() {
			return this._ctrl_package;
		}

		public String getNSURI() {
			return this._ns_uri;
		}

		public String getNSDefaultPrefix() {
			return this._ns_default_prefix;
		}

	}
}
