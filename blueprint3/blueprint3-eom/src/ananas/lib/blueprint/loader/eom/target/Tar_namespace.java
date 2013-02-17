package ananas.lib.blueprint.loader.eom.target;

import java.util.ArrayList;
import java.util.List;

import ananas.lib.blueprint.core.util.DefaultMacroProperties;
import ananas.lib.blueprint.core.util.IMacroProperties;

public class Tar_namespace extends TargetBase {

	private final IMacroProperties mProps = new DefaultMacroProperties();
	private final List<Tar_class> mClassList = new ArrayList<Tar_class>();

	private boolean mEnableExport;
	private Tar_eom mParent;

	interface Const {
		String ns_uri = "namespace:uri";
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
		this.mClassList.add(aClass);
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

	@Override
	public ITargetNode[] getChildren() {
		List<Tar_class> list = this.mClassList;
		return list.toArray(new Tar_class[list.size()]);
	}

	@Override
	public void setParent(ITargetNode node) {
		this.mParent = (Tar_eom) node;
	}

}
