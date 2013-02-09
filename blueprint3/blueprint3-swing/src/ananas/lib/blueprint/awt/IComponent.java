package ananas.lib.blueprint.awt;

import java.awt.Component;

import ananas.lib.blueprint.core.dom.BPAttribute;

public interface IComponent {

	// boolean set_attribute_xxx (BPAttribute attr);

	// boolean append_child_xxx(Object obj);

	// attribute

	boolean set_attribute_x(BPAttribute attr);

	boolean set_attribute_y(BPAttribute attr);

	boolean set_attribute_height(BPAttribute attr);

	boolean set_attribute_width(BPAttribute attr);

	boolean set_attribute_test(BPAttribute attr);

	// other

	Component getTargetComponent();
}
