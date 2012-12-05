package ananas.lib.blueprint2.awt.util;

public interface IResponseChain {

	boolean appendNode(IResponseChainNode node);

	boolean removeNode(IResponseChainNode node);

}
