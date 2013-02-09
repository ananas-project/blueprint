package ananas.lib.blueprint.loader.eom.target;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ananas.lib.blueprint.core.util.DefaultMacroProperties;
import ananas.lib.blueprint.core.util.IMacroProperties;

public class Tar_namespace {

	private final IMacroProperties mProps = new DefaultMacroProperties();
	private final List<Tar_class> mClassList = new ArrayList<Tar_class>();
	private final Map<String, Tar_class> mClassMap = new HashMap<String, Tar_class>();
	private boolean mEnableExport;

	interface Const {
		String ns_uri = "ns:uri";
	}

	public IMacroProperties getProperties() {
		return mProps;
	}

	public void setProperty(Tar_property property) {
		String key = property.getKey();
		String value = property.getValue();
		this.mProps.put(key, value);
	}

	public void addClass(Tar_class aClass) {

		aClass.setOwnerNamespace(this);

		this.mClassList.add(aClass);
		String name = aClass.getName();
		if (this.mClassMap.containsKey(name)) {
			throw new RuntimeException("the name of class is repeat : " + name);
		}
		this.mClassMap.put(name, aClass);
	}

	public void setEnableExport(boolean enableExport) {
		this.mEnableExport = enableExport;
	}

	public List<Tar_class> listMemberClasses() {
		return this.mClassList;
	}

	public boolean enableExport() {
		return this.mEnableExport;
	}

	public void setURI(String value) {
		this.mProps.put(Const.ns_uri, value);
	}

}
