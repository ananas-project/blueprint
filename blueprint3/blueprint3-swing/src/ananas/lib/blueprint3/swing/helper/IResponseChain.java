package ananas.lib.blueprint3.swing.helper;

public interface IResponseChain {

	boolean appendNode(IResponseChainNode node);

	boolean removeNode(IResponseChainNode node);
}
