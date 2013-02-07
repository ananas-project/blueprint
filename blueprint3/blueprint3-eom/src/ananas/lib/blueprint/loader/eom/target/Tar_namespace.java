package ananas.lib.blueprint.loader.eom.target;

import java.util.ArrayList;
import java.util.List;

import ananas.lib.blueprint.core.util.DefaultMacroProperties;
import ananas.lib.blueprint.core.util.IMacroProperties;

public class Tar_namespace {

	private final IMacroProperties mProps = new DefaultMacroProperties();
	private final List<Tar_class> mClassList = new ArrayList<Tar_class>();
	private String mName;

	public void setName(String name) {
		this.mName = name;
	}

	public void setProperty(Tar_property property) {
		String key = property.getKey();
		String value = property.getValue();
		this.mProps.put(key, value);
	}

	public void addClass(Tar_class aClass) {
		this.mClassList.add(aClass);
	}

}
