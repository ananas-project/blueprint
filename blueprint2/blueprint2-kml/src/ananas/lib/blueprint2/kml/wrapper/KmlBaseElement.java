package ananas.lib.blueprint2.kml.wrapper;

import ananas.lib.blueprint2.AbstractElement;
import ananas.lib.blueprint2.dom.INode;

public class KmlBaseElement extends AbstractElement {

	@Override
	public boolean onAppendChild(INode child) {
		return super.appendChild(child);
	}

}
