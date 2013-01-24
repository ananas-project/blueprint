package ananas.lib.blueprint.core.dom;

public class AbstractElement extends AbstractNode implements BPElement {

	@Override
	public boolean setAttribute(BPAttribute attr) {
		return false;
	}

	@Override
	public void tagBegin() {
	}

	@Override
	public void tagEnd() {
	}

}
