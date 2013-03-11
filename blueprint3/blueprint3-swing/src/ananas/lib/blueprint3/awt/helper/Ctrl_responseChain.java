package ananas.lib.blueprint3.awt.helper;

public class Ctrl_responseChain extends Ctrl_AWTObject {

	public Tar_responseChain target_responseChain() {
		return (Tar_responseChain) this.getTarget(true);
	}

	public boolean append_child_responseChainNode(Ctrl_responseChainNode node) {
		Tar_responseChainNode c = node.target_responseChainNode();
		Tar_responseChain p = this.target_responseChain();
		p.appendNode(c);
		return true;
	}
}
