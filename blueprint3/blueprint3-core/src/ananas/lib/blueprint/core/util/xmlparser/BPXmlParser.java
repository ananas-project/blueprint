package ananas.lib.blueprint.core.util.xmlparser;

import java.io.InputStream;

import ananas.lib.blueprint.core.util.xmlhelper.BPXmlHandler;

public interface BPXmlParser {

	void parse(InputStream in, BPXmlHandler h);
}
