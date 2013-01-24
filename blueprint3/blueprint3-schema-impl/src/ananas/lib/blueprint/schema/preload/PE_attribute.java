package ananas.lib.blueprint.schema.preload;

public class PE_attribute implements PreloadElement {

	@Override
	public void setAttr(String name, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void append(PreloadElement child) {
		throw new RuntimeException("not accept the child : " + child);
	}

}
