package ananas.lib.blueprint3.awt.helper;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Tar_responseChain implements IResponseChain {

	private final List<IResponseChainNode> mNodeList;
	private boolean mIsNeedForRebuild;
	private IResponseChainNode mFirstNode;

	public Tar_responseChain() {
		this.mNodeList = new ArrayList<IResponseChainNode>();
	}

	@Override
	public boolean appendNode(IResponseChainNode node) {
		if (this.mNodeList.contains(node)) {
			return false;
		} else {
			this.mNodeList.add(node);
			this.mIsNeedForRebuild = true;
			return true;
		}
	}

	@Override
	public boolean removeNode(IResponseChainNode node) {
		boolean rlt = this.mNodeList.remove(node);
		if (rlt) {
			this.mIsNeedForRebuild = true;
		}
		return rlt;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (this.mIsNeedForRebuild) {
			this.mIsNeedForRebuild = false;
			IResponseChainNode prev = null;
			for (IResponseChainNode node : this.mNodeList) {
				if (prev != null) {
					prev.setNext(node);
				} else {
					this.mFirstNode = node;
				}
				prev = node;
			}
		}

		IResponseChainNode p1st = this.mFirstNode;
		if (p1st != null) {
			p1st.processEvent(event);
		}
	}

}
