package ananas.lib.blueprint.loader.eom;

import java.io.IOException;
import java.io.InputStream;

import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.lang.BPDocumentLoader;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPNamespaceRegistrar;
import ananas.lib.blueprint.core.lang.BlueprintException;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceInfo;
import ananas.lib.blueprint.core.util.nsloader.BPNamespaceLoader;
import ananas.lib.blueprint.loader.eom.ctrl.Ctrl_eom;
import ananas.lib.blueprint.loader.eom.target.Tar_eom;

public class EomNamespaceLoader implements BPNamespaceLoader {

	@Override
	public void load(BPEnvironment envi, BPNamespaceInfo info)
			throws BlueprintException {

		String xmlfile = info.getProperty("eom.xml");
		InputStream in = info.getClass().getResourceAsStream(xmlfile);

		try {

			BPDocumentLoader docLdr = envi.getDocumentLoaderFactory()
					.newLoader();
			BPDocument doc = docLdr.loadDocument(envi, in, "");

			Ctrl_eom eom = (Ctrl_eom) doc.getRootElement();
			Tar_eom teom = eom.getTarget_eom();

			// System.out.println(eom);

			// IEomNamespaceRegFactory regf = new
			// DefaultEomNamespaceRegFactory();
			// IEomNamespaceReg reg = regf.newReg(teom);

			// reg.load(envi);
			// reg.check(envi);
			// reg.register(envi);

			this.loadNS(envi, teom);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (in != null)
				in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void loadNS(BPEnvironment envi, Tar_eom teom) {
		MyBpnsFactory f = new MyBpnsFactory(envi, teom);
		BPNamespace[] nss = f.build();
		BPNamespaceRegistrar nsreg = envi.getNamespaceRegistrar();
		for (BPNamespace ns : nss) {
			nsreg.registerNamespace(ns);
		}
	}

}
