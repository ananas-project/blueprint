package ananas.lib.blueprint.core.xml.parser;

import java.io.IOException;
import java.io.InputStream;

import ananas.lib.blueprint.core.xml.BPXmlException;
import ananas.lib.blueprint.core.xml.helper.BPXmlHandler;

public interface BPXmlParser {

	void parse(InputStream in, BPXmlHandler h) throws IOException,
			BPXmlException;

	boolean enableNamespace();

	void setEnableNamespace(boolean enable);

}
