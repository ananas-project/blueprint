package impl.ananas.blueprint4.core.namespace;

public class Ctr_element extends Ctr_object {

	public Tar_element target_element() {
		return (Tar_element) this.getTarget(true);
	}

	public boolean setAttribute(String uri, String localName, String value) {
		if (localName == null) {
			return false;
		} else if (localName.equals("name")) {
			this.target_element().setName(value);
		} else if (localName.equals("controller")) {
			this.target_element().setControllerClassName(value);
		} else if (localName.equals("target")) {
			this.target_element().setTargetClassName(value);
		} else {
			return super.setAttribute(uri, localName, value);
		}
		return true;
	}
}
