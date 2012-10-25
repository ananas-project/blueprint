package bp2.swing.demo2.gui;

import java.awt.Component;

import javax.swing.JTree;

import ananas.lib.blueprint2.dom.IDocument;

public class TreeView extends BaseView {

	private final JTree mRoot;

	public TreeView() {

		final IDocument doc = this.loadDocument(R.file.treeview_xml);
		this.mRoot = (JTree) doc.findTargetById(R.id.root);

	}

	@Override
	public Component getComponent() {
		return this.mRoot;
	}

}
