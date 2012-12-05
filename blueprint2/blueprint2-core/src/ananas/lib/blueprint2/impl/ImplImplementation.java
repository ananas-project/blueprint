package ananas.lib.blueprint2.impl;

import ananas.lib.blueprint2.dom.IDocument;
import ananas.lib.blueprint2.dom.helper.IBlueprintContext;
import ananas.lib.blueprint2.dom.helper.IClass;
import ananas.lib.blueprint2.dom.helper.IClassRegistrar;
import ananas.lib.blueprint2.dom.helper.IImplementation;
import ananas.lib.blueprint2.dom.helper.INamespace;
import ananas.lib.blueprint2.dom.helper.INamespaceRegistrar;

final class ImplImplementation implements IImplementation {

	private final INamespaceRegistrar mNsReg;
	private final IClassRegistrar mClassReg;
	private final IBlueprintContext mBpContext;

	public ImplImplementation(IBlueprintContext context) {
		this.mNsReg = new ImplNamespaceRegistrar(this);
		this.mClassReg = new ImplClassRegistrar();
		this.mBpContext = context;

		// init load
		String classpath = "ananas.lib.blueprint2.element.base.NamespaceLoader";
		this.mNsReg.loadNamespace(classpath);
	}

	@Override
	public INamespaceRegistrar getNamespaceRegistrar() {
		return this.mNsReg;
	}

	@Override
	public IDocument newDocument(String docURI) {
		IDocument doc = new ImplDocument(docURI, this);
		return doc;
	}

	@Override
	public INamespace newNamespace(String nsURI, String defaultPrefix) {
		return new ImplNamespace(nsURI, defaultPrefix, this);
	}

	@Override
	public IClass findClass(String uri, String localName) {
		return this.mClassReg.findClass(uri, localName);
	}

	@Override
	public IClass findClass(Class<?> aClass) {
		return this.mClassReg.findClass(aClass);
	}

	@Override
	public IClass findClass(Object obj) {
		return this.mClassReg.findClass(obj);
	}

	@Override
	public void registerClass(IClass aClass) {
		String uri = aClass.getNamespaceURI();
		String localName = aClass.getLocalName();
		IClass cls2 = this.mClassReg.findClass(uri, localName);
		if (aClass.equals(cls2)) {
			return;
		} else {
			this.mClassReg.registerClass(aClass);
		}
	}

	@Override
	public IClass getDefaultClass() {
		return this.mClassReg.getDefaultClass();
	}

	@Override
	public void setDefaultClass(IClass defaultClass) {
		this.mClassReg.setDefaultClass(defaultClass);
	}

	@Override
	public IBlueprintContext getBlueprintContext() {
		return this.mBpContext;
	}

}
