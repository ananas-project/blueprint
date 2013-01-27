package ananas.lib.blueprint.core.util;

public interface BPErrorHandler {

	void error(Exception e) throws Exception;

	void fatalError(Exception e) throws Exception;

	void warning(Exception e) throws Exception;

}
