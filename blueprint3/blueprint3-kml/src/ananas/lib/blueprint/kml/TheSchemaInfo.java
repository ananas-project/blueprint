package ananas.lib.blueprint.kml;

import ananas.lib.blueprint.schema.SchemaInfo;

public class TheSchemaInfo implements SchemaInfo {

	@Override
	public String getXsdFileName() {
		return "ogckml22.xsd";
	}

	@Override
	public String getClassMappingFileName() {
		return "ogckml22.xml";
	}

}
