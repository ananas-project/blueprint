package ananas.lib.blueprint.loader.reflect.dom;

import java.io.PrintStream;
import java.util.Map;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

public class RefElement_element extends RefElement {

	private String mLocalName;
	private String mCtrlClass;
	private String mTargetClass;

	public RefElement_element(RefDocument ownerDoc) {
		super(ownerDoc);
	}

	@Override
	public boolean setAttribute(String attrURI, String attrLName,
			String attrValue) {

		if (attrLName == null) {
			return false;

		} else if (attrLName.equals("controllerClass")) {
			this.mCtrlClass = attrValue;

		} else if (attrLName.equals("targetClass")) {
			this.mTargetClass = attrValue;

		} else if (attrLName.equals("name")) {
			this.mLocalName = attrValue;

		} else {
			return false;
		}
		return true;
	}

	@Override
	public boolean appendChild(RefNode child) {

		return false;
	}

	@Override
	public void printSelf(PrintStream out) {
		out.println("<element name='" + this.mLocalName + "' />");
	}

	public void regElement(Map<String, String> properties, BPEnvironment envi,
			BPNamespace ns) {

		properties.put(RefElement_namespace.Prop.ns_localName, this.mLocalName);

		String targetClassName = this.caleClassName(properties,
				this.mTargetClass,
				RefElement_namespace.Prop.ns_defaultTargetClass);
		String ctrlClassName = this.caleClassName(properties, this.mCtrlClass,
				RefElement_namespace.Prop.ns_defaultControllerClass);

		MyElementType.Config conf = new MyElementType.Config();
		conf.targetClass = this.classByName(targetClassName);
		conf.ctrlClass = this.classByName(ctrlClassName);
		conf.ownerNS = ns;
		conf.localName = this.mLocalName;
		BPType elementType = new MyElementType(conf);
		ns.registerType(elementType);

	}

	private String caleClassName(Map<String, String> properties,
			String className, String defaultClassNameKey) {

		if (className == null) {
			className = properties.get(defaultClassNameKey);
		}
		for (int i = 10; className.contains("$("); i--) {
			if (i < 0) {
				throw new RuntimeException(
						"The macro reference is too deep.[text]=" + className);
			}
			className = this.processMacro(properties, className);
		}
		return className;
	}

	interface Macro {
		String begin = "$(";
		String end = ")";
	}

	private String processMacro(Map<String, String> properties, String text) {

		final int i1 = text.indexOf(Macro.begin);
		if (i1 < 0) {
			return text;
		}

		final int i2 = text.indexOf(Macro.end, i1);
		if (i2 < 0) {
			throw new RuntimeException(
					"The macro of string not closed. [string]=" + text);
		}

		String p1 = text.substring(0, i1);
		String p2 = text.substring(i1 + Macro.begin.length(), i2);
		String p3 = text.substring(i2 + Macro.end.length());

		p2 = properties.get(p2);

		return (p1 + p2 + p3);
	}

	private Class<?> classByName(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
