package ananas.lib.blueprint3.awt.helper;

import java.awt.event.ActionListener;

public interface IResponseChain extends ActionListener {

	boolean appendNode(IResponseChainNode node);

	boolean removeNode(IResponseChainNode node);
}
