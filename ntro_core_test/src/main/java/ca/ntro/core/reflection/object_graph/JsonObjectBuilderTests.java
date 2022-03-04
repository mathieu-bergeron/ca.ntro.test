package ca.ntro.core.reflection.object_graph;

import org.junit.Test;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.json.JsonObject;
import ca.ntro.core.reflection.mock.objects.SimpleObject01;
import ca.ntro.core.reflection.mock.objects.SimpleObject02;
import ca.ntro.core.reflection.mock.objects.TestObject01;

public class JsonObjectBuilderTests {

	@Test
	public void jsonObjectBuilder01() {
		SimpleObject01 simpleObject = new SimpleObject01();
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(simpleObject);
		
		JsonObject jsonObject = graph.buildJsonObject();
		
		Ntro.asserter().assertEquals(Ntro.reflection().simpleName(simpleObject.getClass()), jsonObject.get(JsonObject.TYPE_KEY));
		Ntro.asserter().assertEquals("attr01", jsonObject.get("attr01"));
		Ntro.asserter().assertEquals(12, jsonObject.get("attr02"));
	}

	@Test
	public void jsonObjectBuilder02() {
		SimpleObject02 simpleObject = new SimpleObject02("attr01", 12);
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(simpleObject);
		
		JsonObject jsonObject = graph.buildJsonObject();
		
		Ntro.asserter().assertEquals(Ntro.reflection().simpleName(simpleObject.getClass()), jsonObject.get(JsonObject.TYPE_KEY));
		Ntro.asserter().assertEquals("attr01", jsonObject.get("attr01"));
		Ntro.asserter().assertEquals(12, jsonObject.get("attr02"));
	}


}
