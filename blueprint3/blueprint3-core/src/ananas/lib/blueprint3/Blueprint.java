package ananas.lib.blueprint3;

import java.io.IOException;
import java.net.URI;

import ananas.lib.blueprint3.dom.BPDocument;
import ananas.lib.blueprint3.dom.BPDocumentGroup;
import ananas.lib.blueprint3.lang.BPEnvironment;

public interface Blueprint {

	BPEnvironment defaultEnvironment();

	public class Util {

		private static Blueprint s_inst;

		public static Blueprint getInstance() {
			Blueprint inst = s_inst;
			if (inst == null) {
				inst = Private_BlueprintLoader.loadInstance();
				s_inst = inst;
			}
			return inst;
		}

		public static BPDocument loadDocument(String uri) throws IOException {
			BPEnvironment envi = Blueprint.Util.getInstance()
					.defaultEnvironment();
			BPDocumentGroup group = envi.getImplementation()
					.createDocumentGroup(envi);
			return group.openDocument(URI.create(uri), true, true);
		}

		public static BlueprintFactory getFactory(String factoryClass) {
			try {
				Class<?> cls = Class.forName(factoryClass);
				return getFactory(cls);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		public static BlueprintFactory getFactory(Class<?> factoryClass) {
			try {
				return (BlueprintFactory) factoryClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
