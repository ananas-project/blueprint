package impl.ananas.blueprint4.core.namespace;

import ananas.blueprint4.core.lang.BPNode;

public class Ctr_head extends Ctr_object {

	public boolean appendChild(BPNode node) {
		if (node == null) {
			return false;
		} else if (node instanceof Ctr_property) {
			this._setProperty((Ctr_property) node);
		} else {
			return super.appendChild(node);
		}
		return true;
	}

	private void _setProperty(Ctr_property property) {
		Tar_property prop = (Tar_property) property.getTarget(true);
		Tar_head head = (Tar_head) this.getTarget(true);
		head.setProperty(prop);
	}

	public Tar_head target_head() {
		return (Tar_head) this.getTarget(true);
	}

}
