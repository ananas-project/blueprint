package impl.ananas.blueprint4.core.util;

import ananas.blueprint4.core.util.BPDocumentBuilder;
import ananas.blueprint4.core.util.BPDocumentBuilderFactory;

public class BPDocumentBuilderFactoryImpl implements BPDocumentBuilderFactory {

	@Override
	public BPDocumentBuilder createBuilder() {
		return new BPDocumentBuilderImpl();
	}

}
