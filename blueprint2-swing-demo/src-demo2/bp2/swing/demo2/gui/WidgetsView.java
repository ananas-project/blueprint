package bp2.swing.demo2.gui;

import java.awt.Component;

import javax.swing.JPanel;

import ananas.lib.blueprint2.dom.IDocument;

public class WidgetsView extends BaseView {

	private final JPanel mRoot;

	public WidgetsView() {

		final IDocument doc = this.loadDocument(R.file.widgetsview_xml);
		this.mRoot = (JPanel) doc.findTargetById(R.id.root);
	}

	@Override
	public Component getComponent() {
		return this.mRoot;
	}

}
