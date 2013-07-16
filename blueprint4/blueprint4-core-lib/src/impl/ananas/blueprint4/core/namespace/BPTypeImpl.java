package impl.ananas.blueprint4.core.namespace;

import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPElement;
import ananas.blueprint4.core.lang.BPNamespace;
import ananas.blueprint4.core.lang.BPType;
import ananas.lib.util.logging.Logger;

public class BPTypeImpl implements BPType {

	final static Logger log = Logger.Agent.getLogger();

	private final Class<?> _classCtrl;
	private final Class<?> _classTarget;
	private final String _localName;
	private final BPNamespace _ownerNS;

	public BPTypeImpl(BPNamespace namespace, String localName,
			Class<?> controllerClass, Class<?> targetClass) {
		this._ownerNS = namespace;
		this._localName = localName;
		this._classCtrl = controllerClass;
		this._classTarget = targetClass;
	}

	@Override
	public BPNamespace getOwnerNamespace() {
		return this._ownerNS;
	}

	@Override
	public String getLocalName() {
		return this._localName;
	}

	@Override
	public Class<?> getControllerClass() {
		return this._classCtrl;
	}

	@Override
	public Class<?> getTargetClass() {
		return this._classTarget;
	}

	@Override
	public BPElement createController(BPDocument doc) {
		try {
			BPElement ctrl = (BPElement) this._classCtrl.newInstance();
			ctrl.bind(doc);
			ctrl.bind(this);
			return ctrl;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

}
