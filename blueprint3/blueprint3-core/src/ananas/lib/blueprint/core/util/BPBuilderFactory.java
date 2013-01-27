package ananas.lib.blueprint.core.util;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;

public interface BPBuilderFactory {

	BPBuilder newBuilder(BPDocument doc);

	BPBuilder newBuilder(BPElement element);

}
