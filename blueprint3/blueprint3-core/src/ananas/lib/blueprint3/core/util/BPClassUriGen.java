package ananas.lib.blueprint3.core.util;

import java.net.URI;

public class BPClassUriGen {

	public static URI getURI(Class<?> aClass, String shortFileName) {
		if (shortFileName == null)
			shortFileName = "";
		String cname = aClass.getName();
		return URI.create("class:///" + cname + "/" + shortFileName);
	}

	public static URI getURI(Class<?> aClass) {
		return getURI(aClass, null);
	}

}
