package ananas.lib.blueprint.loader.eom.target;

import java.util.ArrayList;
import java.util.List;

public class Tar_class {

	final List<Tar_attribute> mAttrList = new ArrayList<Tar_attribute>();
	final List<Tar_element> mElementList = new ArrayList<Tar_element>();

	private boolean mIsElement = false;
	private String mName;
	private String mExtends;

	public void setIsElement(boolean value) {
		this.mIsElement = value;
	}

	public void addElement_element(Tar_element element) {
		this.mElementList.add(element);
	}

	public void setName(String name) {
		this.mName = name;
	}

	public void addElement_attribute(Tar_attribute attr) {
		this.mAttrList.add(attr);
	}

	public void setExtends(String value) {
		this.mExtends = value;
	}

}
