package ananas.lib.blueprint3.core.lang;

public interface BPFileNameMapper {

	void register(String dotName, String contentType);

	String getContentType(String dotName);
}
