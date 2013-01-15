package ananas.lib.blueprint.core.dom;

import ananas.lib.blueprint.core.lang.BPEnvironment;

public interface BPDocument extends BPNode {

	BPElement getRootElement();

	String getDocumentURI();

	BPEnvironment getEnvironment();

}
