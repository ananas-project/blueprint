package ananas.lib.blueprint.schema.preload;

import java.util.ArrayList;
import java.util.List;

public class PE_element extends PE_object {

	public final List<PE_attribute> m_attr_list;

	public PE_element() {
		this.m_attr_list = new ArrayList<PE_attribute>();
	}

	@Override
	public void setAttr(String name, String value) {
		super.setAttr(name, value);
	}

	@Override
	public void append(PreloadElement child) {

		if (child == null) {
			super.append(child);

		} else if (child instanceof PE_attribute) {
			this.m_attr_list.add((PE_attribute) child);
			return;

		} else {
			super.append(child);
		}

	}

	public List<PE_attribute> getAttrs() {
		return this.m_attr_list;
	}

}
