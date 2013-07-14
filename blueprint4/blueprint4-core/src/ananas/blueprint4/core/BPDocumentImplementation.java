package ananas.blueprint4.core;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.lib.util.SingletonLoader;

public interface BPDocumentImplementation {

	BPDocument createDocument(BPContext context);

	class Factory {

		public static BPDocumentImplementation getDefault() {
			return (BPDocumentImplementation) SingletonLoader
					.load(BPDocumentImplementation.class);
		}
	}

}
