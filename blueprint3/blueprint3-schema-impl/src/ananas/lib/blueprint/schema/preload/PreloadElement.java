package ananas.lib.blueprint.schema.preload;

public interface PreloadElement {

	void setAttr(String name, String value);

	void append(PreloadElement child);

}
