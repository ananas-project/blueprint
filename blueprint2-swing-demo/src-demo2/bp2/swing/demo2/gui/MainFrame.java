package bp2.swing.demo2.gui;

import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import ananas.lib.blueprint2.awt.util.IResponseChainNode;
import ananas.lib.blueprint2.dom.IDocument;

public class MainFrame extends Bp2Ctrl {

	private final JFrame mFrame;
	private final JDesktopPane mMainClient;

	public MainFrame() {
		final IDocument doc = this.loadDocument(R.file.mainframe_xml);
		this.mFrame = (JFrame) doc.findTargetById(R.id.root);
		this.mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		IResponseChainNode chainNode = (IResponseChainNode) doc
				.findTargetById(R.id.resp_chain_node_3);
		chainNode.setHook(this.mRespChainHook);

		this.mMainClient = (JDesktopPane) doc.findTargetById(R.id.main_client);

	}

	private final IResponseChainNode mRespChainHook = new IResponseChainNode() {

		@Override
		public IResponseChainNode getNext() {
			return null;
		}

		@Override
		public void setNext(IResponseChainNode next) {
		}

		@Override
		public IResponseChainNode getHook() {
			return null;
		}

		@Override
		public void setHook(IResponseChainNode hook) {
		}

		@Override
		public boolean processEvent(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd == null) {
				return IResponseChainNode.GOTO_NEXT;
			} else if (cmd.equals(R.command.show_tree_view)) {
				MainFrame.this.showTreeView();
			} else {
				return IResponseChainNode.GOTO_NEXT;
			}
			return IResponseChainNode.DONE;
		}
	};

	public void show() {
		this.mFrame.setVisible(true);
	}

	protected void showTreeView() {
		TreeView tv = new TreeView();
		this._addView(tv);
	}

	private void _addView(IView tv) {
		ChildFrame ch = new ChildFrame();
		ch.setView(tv);
		JInternalFrame iframe = ch.getInternalFrame();
		this.mMainClient.add(iframe);
		iframe.setVisible(true);

		iframe.setResizable(true);
		iframe.setClosable(true);
		iframe.setMaximizable(true);
		iframe.setIconifiable(true);
	}

}
