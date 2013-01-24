package ananas.lib.blueprint.schema.preload;

import java.util.ArrayList;
import java.util.List;

public class PE_element implements PreloadElement {

	public final List<PE_attribute> m_attr_list;

	public PE_element() {
		this.m_attr_list = new ArrayList<PE_attribute>();
	}

	@Override
	public void setAttr(String name, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void append(PreloadElement child) {

		if (child == null) {

		} else if (child instanceof PE_attribute) {
			this.m_attr_list.add((PE_attribute) child);
			return;

		} else {
		}

		throw new RuntimeException("not accept the child : " + child);

	}

}
