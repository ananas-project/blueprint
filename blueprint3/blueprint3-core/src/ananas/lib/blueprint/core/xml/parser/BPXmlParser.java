package ananas.lib.blueprint.core.xml.parser;

import java.io.InputStream;

import ananas.lib.blueprint.core.xml.helper.BPXmlHandler;

public interface BPXmlParser {

	void parse(InputStream in, BPXmlHandler h);
}
