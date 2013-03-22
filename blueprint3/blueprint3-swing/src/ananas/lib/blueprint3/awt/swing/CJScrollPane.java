package ananas.lib.blueprint3.awt.swing;

import java.awt.Component;

import javax.swing.JScrollPane;

import ananas.lib.blueprint3.awt.CComponent;

public class CJScrollPane extends CJComponent {

	public void onTagEnd() {
		super.onTagEnd();
	}

	@Override
	public boolean append_child_(CComponent comp) {
		JScrollPane parent = this.target_JScrollPane();
		Component child = comp.target_component();
		parent.setViewportView(child);
		return true;
	}

	private JScrollPane target_JScrollPane() {
		return (JScrollPane) this.getTarget(true);
	}

}
