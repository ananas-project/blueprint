package ananas.lib.blueprint.schema.preload;

import java.util.ArrayList;
import java.util.List;

public class PE_preload implements PreloadElement {

	private final List<PE_element> m_element_list;

	public PE_preload() {
		this.m_element_list = new ArrayList<PE_element>();
	}

	@Override
	public void setAttr(String name, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void append(PreloadElement child) {

		if (child == null) {

		} else if (child instanceof PE_element) {
			this.m_element_list.add((PE_element) child);
			return;

		} else {
		}

		throw new RuntimeException("not accept the child : " + child);

	}

}
