package ananas.lib.blueprint.loader.eom.target;

import java.util.ArrayList;
import java.util.List;

public class TMapping {

	private final List<TNamespace> mNsList = new ArrayList<TNamespace>();

	public void addNamespace(TNamespace ns) {
		this.mNsList.add(ns);
	}
}
