package ananas.lib.blueprint3.core.lang;

import ananas.lib.blueprint3.core.dom.BPAttribute;
import ananas.lib.blueprint3.core.dom.BPDocument;
import ananas.lib.blueprint3.core.dom.BPElement;
import ananas.lib.blueprint3.core.dom.BPText;

public interface BPType {

	Class<?> getTargetClass();

	Class<?> getControllerClass();

	String getLocalName();

	BPNamespace getOwnerNamespace();

	boolean appendElementToParent(BPElement parent, BPElement child);

	boolean appendTextToParent(BPElement parent, BPText text);

	boolean setAttributeForParent(BPElement parent, BPAttribute attr);

	BPElement createElement(BPDocument doc);

}
