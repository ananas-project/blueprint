package ananas.blueprint4.core.lang;

import java.util.List;

public interface BPNamespace {

	String getURI();

	String getDefaultPrefix();

	List<BPType> listTypes();

	BPType get(String localName);

	BPXMLSchema getXMLSchema();

}
