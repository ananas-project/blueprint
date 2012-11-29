package ananas.lib.blueprint2.ojm.impl;

import java.io.InputStream;

import ananas.lib.blueprint2.Blueprint2;
import ananas.lib.blueprint2.dom.IDocument;
import ananas.lib.blueprint2.ojm.OJMapperConfiguration;
import ananas.lib.blueprint2.ojm.OJMapperFactory;
import ananas.lib.blueprint2.ojm.elements.OJMNamespaceLoader;

public class DefaultOJMapperConfigurationImpl implements OJMapperConfiguration {

	private final static String default_conf = "/ojm.conf.xml";

	public DefaultOJMapperConfigurationImpl() {
	}

	@Override
	public OJMapperFactory getMapperFactory() {
		try {
			String confFileName = default_conf;
			InputStream is = "".getClass().getResourceAsStream(confFileName);
			Blueprint2 bp = Blueprint2.getInstance();
			bp.getImplementation().getNamespaceRegistrar()
					.loadNamespace(OJMNamespaceLoader.class);
			IDocument doc = bp.loadDocument(is, null);
			OJMapperConfiguration conf = (OJMapperConfiguration) doc
					.findTargetById("conf");
			return conf.getMapperFactory();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
