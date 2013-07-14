package impl.ananas.blueprint4.core.namespace;

import java.io.InputStream;
import java.util.Properties;

import ananas.blueprint4.core.Blueprint;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPNamespace;
import ananas.blueprint4.core.namespace.BPNsImplFactory;
import ananas.lib.util.logging.Logger;

public class BPNsImplFactoryImpl implements BPNsImplFactory {

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

			BPDocument docTypes = null;
			{
				String name = prop.getProperty(BPNsImplFactory.key_ns_types);
				InputStream in = ref.getClass().getResourceAsStream(name);
				docTypes = Blueprint.Util.getDefault().getEnvironment()
						.loadBPDocument(in);
				in.close();
			}
			{
				String name = prop.getProperty(BPNsImplFactory.key_ns_scheme);
				MyInputProvider inProvider = new MyInputProvider(
						ref.getClass(), name);
			}

			BPNamespaceImpl.Context cont = new BPNamespaceImpl.Context();
			BPNamespace newNS = new BPNamespaceImpl(cont);
			return newNS;

		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	class MyInputProvider {

		public MyInputProvider(Class<? extends Object> class1, String name) {
			// TODO Auto-generated constructor stub
		}
	}

}
