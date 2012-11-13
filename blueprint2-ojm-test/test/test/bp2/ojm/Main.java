package test.bp2.ojm;

import test.bp2.ojm.objects.TestingObject1;
import ananas.lib.blueprint2.ojm.DefaultOJMapperConfiguration;
import ananas.lib.blueprint2.ojm.OJMapper;
import ananas.lib.blueprint2.ojm.OJMapperFactory;

public class Main {

	public static void main(String[] args) {
		OJMapperFactory cvtf = (new DefaultOJMapperConfiguration())
				.getMapperFactory();
		OJMapper cvt = cvtf.createMapper();
		final TestingObject1 obj1 = new TestingObject1();
		final String json1 = cvt.convertObjectToJSONString(obj1);
		final TestingObject1 obj2 = (TestingObject1) cvt
				.convertJSONStringToObject(TestingObject1.class, json1);
		final String json2 = cvt.convertObjectToJSONString(obj2);
		System.out.println("info:json1=" + json1);
		System.out.println("info:json2=" + json2);
		if (json1.equals(json2)) {
			System.out.println("info:[OK]");
		} else {
			System.err.println("error:json1 not eq json2");
		}
		System.out.println("info:[THE END]");
	}

}
