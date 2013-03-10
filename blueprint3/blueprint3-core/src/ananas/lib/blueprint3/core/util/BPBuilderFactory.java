package ananas.lib.blueprint3.core.util;

import ananas.lib.blueprint3.core.dom.BPDocument;
import ananas.lib.blueprint3.core.dom.BPElement;

public interface BPBuilderFactory {

	BPBuilder newBuilder(BPDocument doc);

	BPBuilder newBuilder(BPElement element);

}
