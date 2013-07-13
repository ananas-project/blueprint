package ananas.blueprint4.core.util;

import ananas.lib.util.SingletonLoader;

public interface BPDocumentBuilderFactory {

	BPDocumentBuilder createBuilder();

	class Agent {

		private static BPDocumentBuilderFactory _inst;

		public static BPDocumentBuilderFactory getDefault() {
			if (_inst == null) {
				_inst = (BPDocumentBuilderFactory) SingletonLoader
						.load(BPDocumentBuilderFactory.class);
			}
			return _inst;
		}
	}
}
