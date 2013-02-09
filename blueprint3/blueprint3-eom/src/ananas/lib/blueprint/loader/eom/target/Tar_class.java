package ananas.lib.blueprint.loader.eom.target;

import java.util.ArrayList;
import java.util.List;

public class Tar_class {

	final List<Tar_attribute> mAttrList = new ArrayList<Tar_attribute>();
	final List<Tar_element> mElementList = new ArrayList<Tar_element>();

	private boolean mIsElement = false;
	private String mName;
	private String mExtends;
	private Tar_namespace mOwnerNS;

	private String mControllerClassName;
	private String mTargetClassName;
	private Class<?> mControllerClass;
	private Class<?> mTargetClass;
	private String mJavaName;

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

	public void setOwnerNamespace(Tar_namespace ownerNS) {
		this.mOwnerNS = ownerNS;
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

	public Tar_namespace getOwnerNamespace() {
		return mOwnerNS;
	}

	public String getControllerClassName() {
		return mControllerClassName;
	}

	public String getTargetClassName() {
		return mTargetClassName;
	}

	public List<Tar_attribute> listAttributes() {
		return this.mAttrList;
	}

	public List<Tar_element> listChildren() {
		return this.mElementList;
	}

	interface Const {
		String defaultTargetNameKey = "";
		String defaultCtrlNameKey = "";

	}

	public Class<?> getControllerClass() {
		Class<?> cls = this.mControllerClass;
		if (cls == null) {
			String clsName = this.mControllerClassName;
			String clsNameDefault = this.mOwnerNS.getProperties().get(
					Const.defaultCtrlNameKey);
			this.mControllerClass = cls = this.classForName(clsName,
					clsNameDefault);
		}
		return cls;
	}

	private Class<?> classForName(String clsName, String clsNameDefault) {

		// this.mOwnerNS.getProperties().put( Const.ns_ , ) ;

		if (clsName == null) {
		}

		return null;
	}

	public Class<?> getTargetClass() {
		Class<?> cls = this.mTargetClass;
		if (cls == null) {
			String clsName = this.mTargetClassName;
			String clsNameDefault = this.mOwnerNS.getProperties().get(
					Const.defaultTargetNameKey);
			this.mTargetClass = cls = this
					.classForName(clsName, clsNameDefault);
		}
		return cls;
	}

	public void setJavaName(String value) {
		this.mJavaName = value;
	}

}
