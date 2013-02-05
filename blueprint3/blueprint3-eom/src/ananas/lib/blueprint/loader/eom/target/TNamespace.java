package ananas.lib.blueprint.loader.eom.target;

import java.util.HashMap;
import java.util.Map;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;

public class TNamespace {

	private String mNsURI;
	private String mDefaultPrefix;

	private final Map<String, TClass> mClassTable = new HashMap<String, TClass>();
	private final Map<String, String> mProperties = new HashMap<String, String>();

	public BPNamespace genBPNamespace(BPEnvironment envi) {
		String uri = this.mNsURI;

		String defaultPrefix = mDefaultPrefix;
		BPNamespace ns = envi.getImplementation().createNamespace(envi, uri,
				defaultPrefix);

		return ns;
	}

	public void addClass(TClass aClass) {
		String localName = aClass.getLocalName();
		this.mClassTable.put(localName, aClass);
	}

	public void addProperty(TProperty prop) {
		this.mProperties.put(prop.getKey(), prop.getValue());
	}

	public TAttr createAttr(String localName) {
		TAttr attr = new TAttr();
		attr.setLocalName(localName);
		attr.setNamespace(this);
		return attr;
	}

	public TClass createClass(String localName) {
		TClass cls = new TClass();
		cls.setLocalName(localName);
		cls.setNamespace(this);
		return cls;
	}

	public TElement createElement(String localName) {
		TElement ele = new TElement();
		ele.setLocalName(localName);
		ele.setNamespace(this);
		return ele;
	}

}
