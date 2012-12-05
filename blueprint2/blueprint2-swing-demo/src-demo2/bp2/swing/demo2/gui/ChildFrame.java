package bp2.swing.demo2.gui;

import java.awt.Component;

import javax.swing.JInternalFrame;

import ananas.lib.blueprint2.dom.IDocument;

public class ChildFrame extends Bp2Ctrl {

	private final JInternalFrame mFrame;

	public ChildFrame() {

		final IDocument doc = this.loadDocument(R.file.childframe_xml);
		this.mFrame = (JInternalFrame) doc.findTargetById(R.id.root);

		// IResponseChainNode chainNode = (IResponseChainNode) doc
		// .findTargetById(R.id.resp_chain_node_3);
		// chainNode.setHook(this.mRespChainHook);

	}

	public void setView(IView view) {
		Component vp = view.getComponent();
		this.mFrame.getContentPane().add(vp);
	}

	public JInternalFrame getInternalFrame() {
		return this.mFrame;
	}

}
