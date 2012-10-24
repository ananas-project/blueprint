package ananas.lib.blueprint2.element.base;

import ananas.lib.blueprint2.dom.helper.IImplementation;
import ananas.lib.blueprint2.dom.helper.INamespace;
import ananas.lib.blueprint2.dom.helper.INamespaceLoader;

public class NamespaceLoader implements INamespaceLoader {

	class MyHelper {

		private final INamespace mNS;
		private final String mURI;

		public MyHelper(INamespace ns) {
			this.mNS = ns;
			this.mURI = ns.getNamespaceURI();
		}

		public void reg(String localName, Class<?> classWrapper,
				Class<?> classTarget) {

			this.mNS.registerClass(this.mURI, localName, classWrapper,
					classTarget);
		}
	}

	@Override
	public INamespace load(IImplementation impl) {
		String uri = "xmlns:ananas:blueprint:base";
		String defaultPrefix = "bp";
		INamespace ns = impl.newNamespace(uri, defaultPrefix);
		MyHelper h = new MyHelper(ns);
		{
			// attribute
			// h.reg("xmlns", BaseAttr.class, URI.class);

			h.reg("id", BaseAttr.class, String.class);
			h.reg("type", BaseAttr.class, String.class);
			h.reg("value", BaseAttr.class, String.class);

		}
		{
			// element
			h.reg("Blueprint", BpBlueprintElement.class, BpBlueprint.class);
			h.reg("Import", BpImportElement.class, BpImport.class);
			h.reg("Link", BpLinkElement.class, BpLink.class);
			h.reg("Head", BpHeadElement.class, BpHead.class);
			h.reg("Body", BpBodyElement.class, BpBody.class);
		}
		return ns;
	}

}
