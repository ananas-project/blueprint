package ananas.lib.blueprint2.ojm;

public interface OJMapper {

	String convertObjectToJSONString(Object obj);

	Object convertJSONStringToObject(Class<?> aClass, String json);

}
