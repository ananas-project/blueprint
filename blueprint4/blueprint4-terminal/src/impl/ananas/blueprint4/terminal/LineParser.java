package impl.ananas.blueprint4.terminal;

public interface LineParser {

	void parse(String line, LineParserHandler h) throws LineParserException;
}
