package ananas.lib.blueprint.schema.preload;

public class PE_property extends PE_object {

	private String mValue;

	@Override
	public void setAttr(String name, String value) {

		if (name == null) {
			super.setAttr(name, value);

		} else if (name.equals("value")) {
			this.mValue = value;
		} else {
			super.setAttr(name, value);
		}
	}

	@Override
	public void append(PreloadElement child) {
		super.append(child);
	}

	public String getValue() {
		return this.mValue ;
	}


}
