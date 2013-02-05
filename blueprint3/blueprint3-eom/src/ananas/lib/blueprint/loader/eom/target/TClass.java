package ananas.lib.blueprint.loader.eom.target;

public class TClass {

	private TNamespace mNS;
	private String mLocalName;

	public void setNamespace(TNamespace ns) {
		this.mNS = ns;
	}

	public void setLocalName(String localName) {
		this.mLocalName = localName;
	}

	public String getLocalName() {
		return this.mLocalName;
	}

	public TNamespace getNamespace() {
		return this.mNS;
	}
}
