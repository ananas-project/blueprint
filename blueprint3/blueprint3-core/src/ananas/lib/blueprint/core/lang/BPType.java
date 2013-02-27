package ananas.lib.blueprint.core.lang;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.dom.BPNode;

public interface BPType {

	Class<?> getTargetClass();

	Class<?> getControllerClass();

	String getLocalName();

	BPNamespace getOwnerNamespace();

	boolean appendChildToParent(BPElement parent, BPNode child);

	boolean setAttributeForParent(BPElement parent, BPAttribute attr);

	BPElement createElement(BPDocument doc);

}
