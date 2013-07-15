package impl.ananas.blueprint4.core.namespace;

public class Ctr_element extends Ctr_object {

	public Tar_element target_element() {
		return (Tar_element) this.getTarget(true);
	}

}
