package ananas.lib.blueprint2.swt;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;

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

		public void reg(String localName, Class<?> classTarget) {

			try {
				if (localName == null) {
					localName = classTarget.getSimpleName();
				}
				String className = classTarget.getName() + "Wrapper";
				Class<?> classWrapper = Class.forName(className);

				this.mNS.registerClass(this.mURI, localName, classWrapper,
						classTarget);

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public INamespace load(IImplementation impl) {
		String uri = "xmlns:ananas:blueprint:swt";
		String defaultPrefix = "swt";
		INamespace ns = impl.newNamespace(uri, defaultPrefix);
		MyHelper h = new MyHelper(ns);
		{
			// attribute
			// h.reg("align", AwtBaseAttr.class, String.class);

		}
		{
			// element
			// h.reg("blueprint", CBlueprintElement.class, CBlueprint.class);

			// h.reg(null, Object.class);
			h.reg(null, Device.class);
			h.reg(null, Display.class);

		}
		return ns;
	}
}
