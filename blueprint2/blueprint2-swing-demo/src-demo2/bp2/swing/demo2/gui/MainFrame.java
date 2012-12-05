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

		this.showWidgets2View();

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

			} else if (cmd.equals(R.command.show_table_view)) {
				MainFrame.this.showTableView();

			} else if (cmd.equals(R.command.show_widgets_view)) {
				MainFrame.this.showWidgetsView();
			} else if (cmd.equals(R.command.show_widgets2_view)) {
				MainFrame.this.showWidgets2View();

			} else {
				return IResponseChainNode.GOTO_NEXT;
			}
			return IResponseChainNode.DONE;
		}
	};
	private int mIFrameY;
	private int mIFrameX;

	public void show() {
		this.mFrame.setVisible(true);
	}

	protected void showWidgets2View() {
		IView tv = new WidgetsView2();
		this._addView(tv);
	}

	protected void showWidgetsView() {
		IView tv = new WidgetsView();
		this._addView(tv);
	}

	protected void showTableView() {
		TableView tv = new TableView();
		this._addView(tv);
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

		int w, h, x, y;
		x = ((this.mIFrameX++) % 10) * 24;
		y = ((this.mIFrameY++) % 10) * 24;
		w = 480;
		h = 320;
		iframe.setBounds(x, y, w, h);
	}

}
