package ananas.lib.blueprint.core.xml.helper;

public interface BPXmlLocator {

	// Return the column number where the current document event ends.
	int getColumnNumber();

	// Return the line number where the current document event ends.
	int getLineNumber();

	// Return the public identifier for the current document event.
	// String getPublicId();

	// Return the system identifier for the current document event.
	// String getSystemId();
}
