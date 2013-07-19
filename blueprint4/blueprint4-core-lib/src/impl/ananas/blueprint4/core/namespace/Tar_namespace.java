package impl.ananas.blueprint4.core.namespace;

public class Tar_namespace {

	private Tar_body _body;
	private Tar_head _head;

	public void setBody(Tar_body body) {
		this._body = body;
	}

	public void setHead(Tar_head head) {
		this._head = head;
	}

	public Tar_head getHead() {
		return this._head;
	}

	public Tar_body getBody() {
		return this._body;
	}

}
