package ananas.lib.blueprint.loader.eom.target.util;

import ananas.lib.blueprint.loader.eom.target.ITargetNode;

public class TargetTravel {

	public void go(ITargetNode node, TargetTravelCallback callback) {

		// if (node == null) {return ;}

		ITargetNode[] array = node.getChildren();
		if (array == null) {
			return;
		}
		for (ITargetNode ch : array) {
			callback.findChild(ch, node);
			this.go(ch, callback);
		}

	}

}
