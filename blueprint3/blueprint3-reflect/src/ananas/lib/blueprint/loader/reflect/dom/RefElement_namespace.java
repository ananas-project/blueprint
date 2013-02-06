package ananas.lib.blueprint.loader.reflect.dom;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;

public class RefElement_namespace extends RefElement {

	private final Map<String, String> mProperties = new HashMap<String, String>();
	private final List<RefElement_element> mElements = new ArrayList<RefElement_element>();

	public RefElement_namespace(RefDocument ownerDoc) {
		super(ownerDoc);
	}

	@Override
	public boolean setAttribute(String attrURI, String attrLName,
			String attrValue) {

		if (attrLName == null) {
			return false;

		} else if (attrLName.equals("name")) {
			this.mProperties.put(Prop.ns_uri, attrValue);

		} else {
			return false;
		}
		return true;
	}

	@Override
	public boolean appendChild(RefNode child) {

		if (child instanceof RefElement_property) {
			RefElement_property prop = (RefElement_property) child;
			String key = prop.getKey();
			String value = prop.getValue();
			this.mProperties.put(key, value);

		} else if (child instanceof RefElement_element) {
			RefElement_element ele = (RefElement_element) child;
			this.mElements.add(ele);

		} else {
			return false;
		}
		return true;
	}

	@Override
	public void printSelf(PrintStream out) {
		out.println("<namespace>");

		for (String key : this.mProperties.keySet()) {
			String val = this.mProperties.get(key);
			out.println("<property key='" + key + "' value='" + val + "' />");
		}

		for (RefNode ele : this.mElements) {
			ele.printSelf(out);
		}

		out.println("</namespace>");
	}

	public void regNamespace(BPEnvironment envi) {

		String uri = this.getProperty(Prop.ns_uri, false, null);
		String defaultPrefix = this.getProperty(Prop.ns_default_prefix, false,
				null);
		BPNamespace ns = envi.getImplementation().createNamespace(envi, uri,
				defaultPrefix);

		for (RefElement_element element : this.mElements) {
			element.regElement(this.mProperties, envi, ns);
		}

		envi.getNamespaceRegistrar().registerNamespace(ns);

	}

	public interface Prop {
		String ns_default_prefix = "ns:defaultPrefix";
		String ns_uri = "ns:namespaceURI";

		String ns_defaultControllerClass = "ns:defaultControllerClass";
		String ns_defaultTargetClass = "ns:defaultTargetClass";
		String ns_localName = "ns:localName";
	}

	public String getProperty(String key, boolean enableNull,
			String defauleValue) {

		String value = this.mProperties.get(key);
		if (value == null) {
			if (!enableNull) {
				throw new RuntimeException("The property '" + key
						+ "' cannot be null.");
			}
			value = defauleValue;
		}
		return value;
	}

}
