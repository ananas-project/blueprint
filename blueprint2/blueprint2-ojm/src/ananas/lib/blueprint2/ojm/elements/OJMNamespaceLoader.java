package ananas.lib.blueprint2.ojm.elements;

import ananas.lib.blueprint2.dom.helper.IImplementation;
import ananas.lib.blueprint2.dom.helper.INamespace;
import ananas.lib.blueprint2.dom.helper.INamespaceLoader;

public class OJMNamespaceLoader implements INamespaceLoader {

	final static String nsuri = "xmlns:ananas:blueprint:ojm";
	final static String prefix = "ojm";

	@Override
	public INamespace load(IImplementation impl) {
		try {
			INamespace ns = impl.newNamespace(nsuri, prefix);
			MyHelper h = new MyHelper(ns);
			{
				h.attr("path");
			}
			{
				h.reg("OJM", OJM_root.class);
				h.reg("Configuration", OJM_configuration.class);
				h.reg("Import", OJM_import.class);

			}
			return ns;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	class MyHelper {

		private final INamespace mNS;

		public MyHelper(INamespace ns) {
			this.mNS = ns;
		}

		public void attr(String localName) {
			this.mNS.registerClass(this.mNS.getNamespaceURI(), localName,
					OJMAttrBase.class, Object.class);
		}

		public void reg(String localName, Class<?> clazz)
				throws ClassNotFoundException {
			String cn = clazz.getName() + "Element";
			String uri = this.mNS.getNamespaceURI();
			Class<?> wrapperClass = Class.forName(cn);
			Class<?> targetClass = clazz;
			this.mNS.registerClass(uri, localName, wrapperClass, targetClass);

		}
	}

}
