package impl.ananas.blueprint4.terminal;

public interface LineParserHandler {

	void onPart(String part);

	void onCString(String str);

}
