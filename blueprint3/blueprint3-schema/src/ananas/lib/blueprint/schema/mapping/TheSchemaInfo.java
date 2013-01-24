package ananas.lib.blueprint.schema.mapping;

import ananas.lib.blueprint.schema.SchemaInfo;

public class TheSchemaInfo implements SchemaInfo {

	@Override
	public String getXsdFileName() {
		return "class-mapping.xsd";
	}

	@Override
	public String getClassMappingFileName() {
		return "class-mapping.xml";
	}

}
