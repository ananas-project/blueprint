package impl.ananas.blueprint4.core.namespace;

public class Tar_element {

	private String _name;
	private String _nameTarget;
	private String _nameController;

	public void setName(String value) {
		this._name = value;
	}

	public void setControllerClassName(String value) {
		this._nameController = value;
	}

	public void setTargetClassName(String value) {
		this._nameTarget = value;
	}

	public String getLocalName() {
		return this._name;
	}

	public String getTargetName() {
		return this._nameTarget;
	}

	public String getControllerName() {
		return this._nameController;
	}

}
