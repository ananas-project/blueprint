package ananas.lib.blueprint.core.xml.helper;

import ananas.lib.blueprint.core.xml.BPXmlException;

public interface BPXmlErrorHandler {

	// Receive notification of a recoverable error.
	void error(BPXmlException exception);

	// Receive notification of a non-recoverable error.
	void fatalError(BPXmlException exception);

	// Receive notification of a warning.
	void warning(BPXmlException exception);
}
