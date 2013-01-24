package ananas.lib.blueprint.schema.xsd;

import ananas.lib.blueprint.schema.SchemaInfo;

public class TheSchemaInfo implements SchemaInfo {

	@Override
	public String getXsdFileName() {
		return "XMLSchema.xsd";
	}

	@Override
	public String getClassMappingFileName() {
		return "XMLSchema.xml";
	}

}
