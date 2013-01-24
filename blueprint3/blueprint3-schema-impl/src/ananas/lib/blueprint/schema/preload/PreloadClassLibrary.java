package ananas.lib.blueprint.schema.preload;

public class PreloadClassLibrary {

	private static PreloadClassLibrary s_inst = new PreloadClassLibrary();

	public static PreloadClassLibrary getInstance() {
		return s_inst;
	}

	private String mPackage;

	private PreloadClassLibrary() {
		this.mPackage = this.getClass().getPackage().getName();
	}

	public PreloadElement createElement(String uri, String localName) {
		try {
			String className = this._normalClassName("PE_" + localName);
			Class<?> cls = Class.forName(this.mPackage + "." + className);
			return (PreloadElement) cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println();
		}
		return null;
	}

	private String _normalClassName(String name) {
		StringBuilder sb = new StringBuilder();
		char[] chs = name.toCharArray();
		for (char ch : chs) {
			if ('0' <= ch && ch <= '9') {
				sb.append(ch);
			} else if ('a' <= ch && ch <= 'z') {
				sb.append(ch);
			} else if ('A' <= ch && ch <= 'Z') {
				sb.append(ch);
			} else {
				sb.append('_');
			}
		}
		return sb.toString();
	}

}
