package ananas.lib.blueprint.xmlparser;

public interface INamespaceMapper {

	String prefixToURI(String prefix);

	String findUriByQName(String qName);

}
