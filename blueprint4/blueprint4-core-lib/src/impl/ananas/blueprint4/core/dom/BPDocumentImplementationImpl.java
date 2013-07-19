package impl.ananas.blueprint4.core.dom;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.BPDocumentImplementation;
import ananas.blueprint4.core.lang.BPDocument;

public class BPDocumentImplementationImpl implements BPDocumentImplementation {

	@Override
	public BPDocument createDocument(BPContext context) {
		return new   BPDocumentImpl (  context , this  ) ;
	}

}
