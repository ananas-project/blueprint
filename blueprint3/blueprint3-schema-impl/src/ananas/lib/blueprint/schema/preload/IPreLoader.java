package ananas.lib.blueprint.schema.preload;

import java.io.IOException;

import org.xml.sax.SAXException;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;

public interface IPreLoader {

	BPNamespace loadNamespace(BPEnvironment envi, Object classpath,
			String xmlFileName) throws SAXException, IOException;

}
