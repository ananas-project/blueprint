package ananas.lib.blueprint3.element.bpbase;

import ananas.lib.blueprint3.core.dom.BPAttribute;
import ananas.lib.blueprint3.core.lang.BPEnvironment;

public class CtrlImport extends CtrlObject {

	public boolean set_attribute_type(BPAttribute attr) {
		this.target_import().setType(attr.getValue());
		return true;
	}

	public boolean set_attribute_value(BPAttribute attr) {
		this.target_import().setValue(attr.getValue());
		return true;
	}

	public TarImport target_import() {
		return (TarImport) this.getTarget(true);
	}

	public void onTagEnd() {
		super.onTagEnd();

		String nsInfoName = this.target_import().getValue();
		BPEnvironment envi = this.getOwnerDocument().getEnvironment();
		envi.loadNamespace(nsInfoName, true);

	}

}
