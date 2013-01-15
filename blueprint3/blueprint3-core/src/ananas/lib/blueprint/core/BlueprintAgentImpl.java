package ananas.lib.blueprint.core;

class BlueprintAgentImpl {

	private static Blueprint s_inst;

	public static Blueprint _theInstance() {
		Blueprint inst = s_inst;
		if (inst == null) {
		}
		return inst;
	}

}
