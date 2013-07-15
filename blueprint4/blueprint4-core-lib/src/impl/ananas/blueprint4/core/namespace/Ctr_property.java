package impl.ananas.blueprint4.core.namespace;

import ananas.blueprint4.core.lang.BPNode;
import ananas.blueprint4.core.lang.BPText;

public class Ctr_property extends Ctr_object {

	public Tar_property target_property() {
		return (Tar_property) this.getTarget(true);
	}

	public boolean appendChild(BPNode child) {
		if (child == null) {
			return false;
		} else if (child instanceof BPText) {
			String s = ((BPText) child).getData();
			this.target_property().setValue( s ) ;
		} else {
			return super.appendChild(child);
		}
		return true;
	}
}
