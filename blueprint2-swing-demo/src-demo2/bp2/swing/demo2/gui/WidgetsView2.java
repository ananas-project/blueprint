package bp2.swing.demo2.gui;

import java.awt.Component;

import javax.swing.JPanel;

import ananas.lib.blueprint2.dom.IDocument;

public class WidgetsView2 extends BaseView {

	private final JPanel mRoot;

	public WidgetsView2() {

		final IDocument doc = this.loadDocument(R.file.widgetsview2_xml);
		this.mRoot = (JPanel) doc.findTargetById(R.id.root);
	}

	@Override
	public Component getComponent() {
		return this.mRoot;
	}

}
