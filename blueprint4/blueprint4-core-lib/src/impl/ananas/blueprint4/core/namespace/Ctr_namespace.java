package impl.ananas.blueprint4.core.namespace;

import ananas.blueprint4.core.lang.BPNode;

public class Ctr_namespace extends Ctr_object {

	public Tar_namespace target_namespace() {
		return (Tar_namespace) this.getTarget(true);
	}

	public boolean appendChild(BPNode node) {
		if (node == null) {
			return false;
		} else if (node instanceof Ctr_body) {
			Ctr_body body = (Ctr_body) node;
			this.target_namespace().setBody(body.target_body());
		} else if (node instanceof Ctr_head) {
			Ctr_head head = (Ctr_head) node;
			this.target_namespace().setHead(head.target_head());
		} else {
			return super.appendChild(node);
		}
		return true;
	}
}
