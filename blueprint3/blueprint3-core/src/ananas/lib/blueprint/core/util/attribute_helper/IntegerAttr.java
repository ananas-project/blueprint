package ananas.lib.blueprint.core.util.attribute_helper;

import ananas.lib.blueprint.core.dom.BPAttribute;

public class IntegerAttr {

	public static int getInt(BPAttribute attr) {
		if (attr == null) {
			return 0;
		}
		String value = attr.getValue();
		if (value == null) {
			return 0;
		}
		return Integer.parseInt(value);
	}

}
