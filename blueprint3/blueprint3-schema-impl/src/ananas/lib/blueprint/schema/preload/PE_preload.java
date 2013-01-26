package ananas.lib.blueprint.schema.preload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PE_preload extends PE_object {

	private final List<PE_element> m_element_list;
	private final List<PE_property> m_property_list;

	public PE_preload() {
		this.m_element_list = new ArrayList<PE_element>();
		this.m_property_list = new ArrayList<PE_property>();
	}

	@Override
	public void setAttr(String name, String value) {
		super.setAttr(name, value);
	}

	@Override
	public void append(PreloadElement child) {

		if (child == null) {
			super.append(child);

		} else if (child instanceof PE_element) {
			this.m_element_list.add((PE_element) child);

		} else if (child instanceof PE_property) {
			this.m_property_list.add((PE_property) child);

		} else {
			super.append(child);
		}

	}

	public Map<String, String> getProperties() {
		Map<String, String> map = new HashMap<String, String>();
		for (PE_property item : this.m_property_list) {
			map.put(item.getName(), item.getValue());
		}
		return map;
	}

	public List<PE_element> getElements() {
		return this.m_element_list;
	}

}
