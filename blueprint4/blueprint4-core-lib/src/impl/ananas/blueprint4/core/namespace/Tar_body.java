package impl.ananas.blueprint4.core.namespace;

import java.util.ArrayList;
import java.util.List;

public class Tar_body {

	final List<Tar_element> _elementList = new ArrayList<Tar_element>();

	public void addElement(Tar_element element) {
		this._elementList.add(element);
	}

	public List<Tar_element> listElements() {
		return this._elementList;
	}

}
