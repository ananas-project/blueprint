package ananas.lib.blueprint.schema.preload;

import java.util.List;
import java.util.Map;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

public class PreloadResult {

	private PE_preload mRoot;
	private String mDefaultPrefix;
	private String mNsURI;
	private String mElementClassNamePattern;
	private String mAttrClassNamePattern;
	private String mPackage;
	private String m_target_attr_package;
	private String m_target_attr_pattern;
	private String m_target_element_package;
	private String m_target_element_pattern;
	private String m_ctrl_attr_pattern;
	private String m_ctrl_attr_package;
	private String m_ctrl_element_package;
	private String m_ctrl_element_pattern;

	public PreloadResult() {
	}

	public String getNamespaceURI() {
		return this.mNsURI;
	}

	public String getDefaultPrefix() {
		return this.mDefaultPrefix;
	}

	public void regClassesToNamespace(BPNamespace ns) {

		BPEnvironment envi = ns.getOwnerEnvironment();

		List<PE_element> list = this.mRoot.getElements();

		for (PE_element element : list) {
			{
				String localName = element.getName();
				Class<?> ctrlClass = this._classForName(
						this.m_ctrl_element_package,
						this.m_ctrl_element_pattern, localName);
				Class<?> targetClass = this._classForName(
						this.m_target_element_package,
						this.m_target_element_pattern, localName);

				BPType type = envi.getImplementation().createType(ns,
						localName, ctrlClass, targetClass);
				ns.registerType(type);
			}

			List<PE_attribute> atts = element.getAttrs();
			for (PE_attribute attr : atts) {

				String localName = attr.getName();
				Class<?> ctrlClass = this._classForName(
						this.m_ctrl_attr_package, this.m_ctrl_attr_pattern,
						localName);
				Class<?> targetClass = this._classForName(
						this.m_target_attr_package, this.m_target_attr_pattern,
						localName);

				BPType type = envi.getImplementation().createType(ns,
						localName, ctrlClass, targetClass);
				ns.registerType(type);

			}

		}
	}

	private Class<?> _classForName(String pkg, String namePattern,
			String localName) {

		String shortName = namePattern.replace("$(localName)", localName);
		shortName = this._normalClassName(shortName);

		String classpath = pkg + "." + shortName;

		try {
			return Class.forName(classpath);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private String _normalClassName(String name) {

		StringBuilder sb = new StringBuilder();
		for (char ch : name.toCharArray()) {
			if ('0' <= ch && ch <= '9') {
				sb.append(ch);
			} else if ('a' <= ch && ch <= 'z') {
				sb.append(ch);
			} else if ('A' <= ch && ch <= 'Z') {
				sb.append(ch);
			} else {
				sb.append('_');
			}
		}
		return sb.toString();
	}

	public void load(PreloadElement root) {

		this.mRoot = (PE_preload) root;

		final String target_attr_package = "target_attr_package";
		final String target_attr_pattern = "target_attr_pattern";
		final String target_element_package = "target_element_package";
		final String target_element_pattern = "target_element_pattern";

		final String ctrl_attr_package = "ctrl_attr_package";
		final String ctrl_attr_pattern = "ctrl_attr_pattern";
		final String ctrl_element_package = "ctrl_element_package";
		final String ctrl_element_pattern = "ctrl_element_pattern";

		Map<String, String> prop = this.mRoot.getProperties();
		this.mDefaultPrefix = prop.get("defaultPrefix");
		this.mNsURI = prop.get("namespace");
		// //
		this.m_target_attr_package = prop.get(target_attr_package);
		this.m_target_attr_pattern = prop.get(target_attr_pattern);
		this.m_target_element_package = prop.get(target_element_package);
		this.m_target_element_pattern = prop.get(target_element_pattern);

		this.m_ctrl_attr_package = prop.get(ctrl_attr_package);
		this.m_ctrl_attr_pattern = prop.get(ctrl_attr_pattern);
		this.m_ctrl_element_package = prop.get(ctrl_element_package);
		this.m_ctrl_element_pattern = prop.get(ctrl_element_pattern);
	}

}
