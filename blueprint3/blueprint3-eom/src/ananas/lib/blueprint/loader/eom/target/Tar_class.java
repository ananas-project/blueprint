package ananas.lib.blueprint.loader.eom.target;

import java.util.ArrayList;
import java.util.List;

public class Tar_class {

	final List<Tar_attribute> mAttrList = new ArrayList<Tar_attribute>();
	final List<Tar_element> mElementList = new ArrayList<Tar_element>();

	private boolean mIsElement = false;
	private String mName;
	private String mExtends;

	private String mControllerClassName;
	private String mTargetClassName;

	private String mJavaName;
	private String mLocalName;

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

	public String getName() {
		return this.mName;
	}

	public String getJavaName() {
		return this.mJavaName;
	}

	public String getLocalName() {
		return this.mLocalName;
	}

	public void setTargetClass(String value) {
		this.mTargetClassName = value;
	}

	public void setControllerClass(String value) {
		this.mControllerClassName = value;
	}

	public boolean isElement() {
		return mIsElement;
	}

	public String getExtends() {
		return mExtends;
	}

	public String getControllerClass() {
		return mControllerClassName;
	}

	public String getTargetClass() {
		return mTargetClassName;
	}

	public List<Tar_attribute> listAttributes() {
		return this.mAttrList;
	}

	public List<Tar_element> listChildren() {
		return this.mElementList;
	}

	public void setJavaName(String value) {
		this.mJavaName = value;
	}

	public void setLocalName(String value) {
		this.mLocalName = value;
	}

}
