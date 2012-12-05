package bp2.swing.demo2.gui;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ananas.lib.blueprint2.dom.IDocument;

public class TableView extends BaseView {

	private final JTable mRoot;

	public TableView() {
		final IDocument doc = this.loadDocument(R.file.tableview_xml);
		this.mRoot = (JTable) doc.findTargetById(R.id.root);

		this.mRoot.setModel(this._getModel());

	}

	private TableModel _getModel() {
		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("id");
		model.addColumn("name");
		model.addColumn("email");

		String[] row1 = { "1", "android", "a@a.com" };
		model.addRow(row1);
		String[] row2 = { "2", "bill", "b@b.com" };
		model.addRow(row2);
		String[] row3 = { "3", "cook", "c@c.com" };
		model.addRow(row3);

		return model;
	}

	@Override
	public Component getComponent() {
		return this.mRoot;
	}

}
