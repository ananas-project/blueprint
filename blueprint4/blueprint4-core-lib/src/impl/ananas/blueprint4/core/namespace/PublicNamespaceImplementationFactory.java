package impl.ananas.blueprint4.core.namespace;

import java.io.InputStream;
import java.util.Properties;

import ananas.blueprint4.core.Blueprint;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPNamespace;
import ananas.blueprint4.core.namespace.BPNamespaceImplementationFactory;
import ananas.lib.util.logging.Logger;

public class PublicNamespaceImplementationFactory implements
		BPNamespaceImplementationFactory {

	static final Logger log = Logger.Agent.getLogger();

	@Override
	public BPNamespace createNS(Object ref, String filename) {
		try {

			Properties prop = new Properties();
			{
				InputStream in = ref.getClass().getResourceAsStream(filename);
				prop.load(in);
				in.close();
			}

			PrivateNamespaceBuilder builder = new PrivateNamespaceBuilder();

			{
				// load types
				String name = prop
						.getProperty(BPNamespaceImplementationFactory.key_ns_types);
				InputStream in = ref.getClass().getResourceAsStream(name);
				BPDocument doc = Blueprint.Util.getDefault().getEnvironment()
						.loadBPDocument(in);
				in.close();
				builder.setTypesDocument(doc);
			}
			{
				// load scheme
				String name = prop
						.getProperty(BPNamespaceImplementationFactory.key_ns_scheme);
				PrivateInputSource inProvider = new MyInputProvider(
						ref.getClass(), name);
				builder.setSchemeInputSource(inProvider);
			}

			return builder.buildNamespace();

		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	class MyInputProvider implements PrivateInputSource {

		public MyInputProvider(Class<? extends Object> class1, String name) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public InputStream openInputStream() {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
