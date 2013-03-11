package ananas.lib.blueprint3.awt.helper;

public interface IResponseChain {

	boolean appendNode(IResponseChainNode node);

	boolean removeNode(IResponseChainNode node);
}
