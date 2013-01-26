package ananas.lib.blueprint.schema.preload;

public class PE_object implements PreloadElement {

	private String mName;

	public PE_object() {
	}

	@Override
	public void setAttr(String name, String value) {

		if ("name".equals(name)) {
			this.mName = value;
			return;
		}

		throw new RuntimeException(this + " not accept the attr : " + name);
	}

	@Override
	public void append(PreloadElement child) {
		throw new RuntimeException(this + " not accept the child : " + child);
	}

	public String getName() {
		return this.mName;
	}

}
