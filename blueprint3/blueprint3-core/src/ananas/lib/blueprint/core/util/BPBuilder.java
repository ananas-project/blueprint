package ananas.lib.blueprint.core.util;

import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;

public interface BPBuilder {

	ContentHandler getContentHandler();

	ErrorHandler getErrorHandler();

}
