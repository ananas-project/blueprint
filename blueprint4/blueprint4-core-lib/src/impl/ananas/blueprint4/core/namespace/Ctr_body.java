package impl.ananas.blueprint4.core.namespace;

import ananas.blueprint4.core.lang.BPNode;

public class Ctr_body extends Ctr_object {

	public boolean appendChild(BPNode node) {
		if (node == null) {
			return false;
		} else if (node instanceof Ctr_element) {
			this._addElement((Ctr_element) node);
		} else {
			return super.appendChild(node);
		}
		return true;
	}

	public Tar_body target_body() {
		return (Tar_body) this.getTarget(true);
	}

	private void _addElement(Ctr_element element) {
		this.target_body().addElement(element.target_element());
	}

}
