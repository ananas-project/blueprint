package ananas.lib.blueprint2.ojm;

public interface OJMapper {

	String convert(Object obj);

	Object convert(Class<?> aClass, String json);

}
