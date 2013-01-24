package ananas.lib.blueprint.core.dom;

public interface BPElementMap {

	void put(String id, BPElement element);

	void remove(String id);

	void remove(BPElement element);

	BPElement get(String id);

	void reset();
}
