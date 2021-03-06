package ananas.lib.blueprint.schema.preload;

import java.io.IOException;

import org.xml.sax.SAXException;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;
import ananas.lib.blueprint.schema.SchemaInfo;
import ananas.lib.blueprint.schema.impl.FinalSchemaLoader;

public class PreLoaderUtil {

	public static boolean isNeedForPreLoading(BPEnvironment envi) {
		String uri = "";
		BPNamespace ns = envi.getNamespaceRegistrar().getNamespace(uri);
		return (ns == null);
	}

	public static void doPreload(BPEnvironment envi) throws SAXException,
			IOException {

		// pure preload
		IPreLoaderFactory plf = new DefaultPreLoaderFactory();
		IPreLoader ldr = plf.newLoader();
		BPNamespace ns1 = ldr.loadNamespace(envi, plf, "xsd-preload.xml");
		BPNamespace ns2 = ldr.loadNamespace(envi, plf, "mapping-preload.xml");
		{
			// xml:lang for xs
			String uri = "http://www.w3.org/XML/1998/namespace";
			String defaultPrefix = "xml";
			BPNamespace ns = envi.getImplementation().createNamespace(envi,
					uri, defaultPrefix);
			BPType type = envi.getImplementation().createType(ns, "lang",
					ananas.lib.blueprint.schema.xsd.ctrl.XSACtrl_lang.class,
					ananas.lib.blueprint.schema.xsd.target.XSA_lang.class);
			ns.registerType(type);
			envi.getNamespaceRegistrar().registerNamespace(ns);
		}
		envi.getNamespaceRegistrar().registerNamespace(ns1);
		envi.getNamespaceRegistrar().registerNamespace(ns2);

		// normal load "mapping" & "xsd"
		FinalSchemaLoader loader;
		SchemaInfo info;
		// xsd
		Class<?> clsXs = ananas.lib.blueprint.schema.xsd.TheSchemaInfo.class;
		info = PreLoaderUtil._getInfo(clsXs);
		loader = new FinalSchemaLoader(envi, info);
		loader.load();
		// mapping
		Class<?> clsMapping = ananas.lib.blueprint.schema.mapping.TheSchemaInfo.class;
		info = PreLoaderUtil._getInfo(clsMapping);
		loader = new FinalSchemaLoader(envi, info);
		loader.load();

	}

	private static SchemaInfo _getInfo(Class<?> cls) {
		try {
			return (SchemaInfo) cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
