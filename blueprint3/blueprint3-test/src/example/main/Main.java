package example.main;

import ananas.lib.blueprint.core.Blueprint;
import ananas.lib.blueprint.core.dom.BPDocument;
import ananas.lib.blueprint.core.dom.BPElement;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.schema.SchemaUtil;
import ananas.lib.blueprint.schema.xsd.TheSchemaInfo;

public class Main {

	public static void main(String arg[]) {

		System.out.println("the Begin");

		try {

			Class<TheSchemaInfo> infoClass = ananas.lib.blueprint.schema.xsd.TheSchemaInfo.class;
			BPEnvironment bpEnvi = Blueprint.getInstance().defaultEnvironment();
			SchemaUtil.loadScheme(bpEnvi, infoClass);

			// BPDocument doc = Blueprint.loadDocument("resource:///test.xml");
			// BPElement element = doc.getRootElement();
			// System.out.println(element);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("the End");

	}
}
