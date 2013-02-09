package ananas.lib.blueprint.loader.eom.target;

import java.util.ArrayList;
import java.util.List;

public class Tar_eom {

	private final List<Tar_namespace> mNsList;

	public Tar_eom() {
		this.mNsList = new ArrayList<Tar_namespace>();
	}

	public void addNamespace(Tar_namespace ns) {
		this.mNsList.add(ns);
	}

	public List<Tar_namespace> listNamespaces() {
		return this.mNsList;
	}

}
