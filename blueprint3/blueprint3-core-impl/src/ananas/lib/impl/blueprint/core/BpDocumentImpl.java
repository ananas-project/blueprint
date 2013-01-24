package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.dom.BPAttribute;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.dom.BPElementMap;
import ananas.lib.blueprint.core.dom.BPNode;
import ananas.lib.blueprint.core.dom.BPText;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespace;
import ananas.lib.blueprint.core.lang.BPType;

public class BpDocumentImpl implements BPDocument {

	private final String mDocURI;
	private final BPEnvironment mEnvironment;
	private BPElement mRoot;
	private BPElementMap mElementReg;

	public BpDocumentImpl(BPEnvironment envi, String uri) {
		this.mEnvironment = envi;
		this.mDocURI = uri;
	}

	@Override
	public boolean appendChild(BPNode newChild) {
		if (newChild instanceof BPElement) {
			this.mRoot = (BPElement) newChild;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeChild(BPNode theChild) {
		if (theChild != null) {
			if (theChild.equals(this.mRoot)) {
				this.mRoot = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public void setParent(BPNode newParent) {
	}

	@Override
	public BPNode getParent() {
		return null;
	}

	@Override
	public BPDocument getOwnerDocument() {
		return null;
	}

	@Override
	public boolean bindOwnerDocument(BPDocument ownerDoc) {
		return false;
	}

	@Override
	public BPType getBPClass() {
		return null;
	}

	@Override
	public boolean bindBPClass(BPType bpClass) {
		return false;
	}

	@Override
	public Object getTarget() {
		return null;
	}

	@Override
	public Object getTarget(boolean create) {
		return null;
	}

	@Override
	public Object createTarget() {
		return null;
	}

	@Override
	public boolean bindTarget(Object target) {
		return false;
	}

	@Override
	public BPElement getRootElement() {
		return this.mRoot;
	}

	@Override
	public String getDocumentURI() {
		return this.mDocURI;
	}

	@Override
	public BPEnvironment getEnvironment() {
		return this.mEnvironment;
	}

	@Override
	public BPText createText(String data) {
		return new BpTextImpl(data);
	}

	private BPNode _createNode(String uri, String localName) {

		BPNamespace pkg = this.mEnvironment.getNamespaceRegistrar()
				.getNamespace(uri);

		if (pkg == null) {
			System.err.println("No namespace!");
			System.err.println("    namespaceURI:" + uri);
			System.err.println("       loaclName:" + localName);
			return null;
		}
		BPType bpcls = pkg.getType(localName);
		if (bpcls == null) {
			System.err.println("No class!");
			System.err.println("    namespaceURI:" + uri);
			System.err.println("       loaclName:" + localName);
			return null;
		}
		Class<?> cls = bpcls.getControllerClass();
		try {
			BPNode node = (BPNode) cls.newInstance();
			node.bindBPClass(bpcls);
			node.bindOwnerDocument(this);
			return node;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BPElement createElement(String uri, String localName) {
		BPNode node = this._createNode(uri, localName);
		if (node instanceof BPElement) {
			BPElement ele = (BPElement) node;
			return ele;
		} else {
			return null;
		}
	}

	@Override
	public BPElement findElementById(String id) {
		BPElementMap ereg = this.mElementReg;
		if (ereg == null) {
			return null;
		} else {
			return ereg.get(id);
		}
	}

	@Override
	public BPElement findElementByURI(String uri) {
		BPElementMap ereg = this.mElementReg;
		if (ereg == null) {
			return null;
		} else {
			String id = uri;
			return ereg.get(id);
		}
	}

	@Override
	public Object findTargetById(String id) {
		BPElement ele = this.findElementById(id);
		if (ele == null) {
			return null;
		} else {
			return ele.getTarget(true);
		}
	}

	@Override
	public Object findTargetByURI(String uri) {
		BPElement ele = this.findElementByURI(uri);
		if (ele == null) {
			return null;
		} else {
			return ele.getTarget(true);
		}
	}

	@Override
	public BPElementMap getElementRegistrar() {
		return this.mElementReg;
	}

	@Override
	public void setElementRegistrar(BPElementMap reg) {
		if (reg != null) {
			this.mElementReg = reg;
		}
	}

	@Override
	public BPAttribute createAttribute(BPElement element, String uri,
			String localName, String value) {

		BPType cls = element.getBPClass().getAttributeType(uri, localName);
		if (cls == null) {
			System.err.println("No attribute class!");
			System.err.println("         element:" + element);
			System.err.println("    namespaceURI:" + uri);
			System.err.println("       loaclName:" + localName);
			System.err.println("           value:" + value);
			return null;
		}
		Class<?> ctrlClass = cls.getControllerClass();
		BPAttribute attr;
		try {
			attr = (BPAttribute) ctrlClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		attr.bindBPClass(cls);
		attr.bindOwnerDocument(this);
		attr.setValue(value);
		return attr;

	}

}
