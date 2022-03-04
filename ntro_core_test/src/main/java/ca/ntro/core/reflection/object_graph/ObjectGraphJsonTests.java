package ca.ntro.core.reflection.object_graph;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.json.JsonObject;
import ca.ntro.core.reflection.mock.linked_list.LinkedList;
import ca.ntro.core.reflection.mock.linked_list.MockLinkedList;
import ca.ntro.core.reflection.mock.linked_list.MockLinkedListElement;
import ca.ntro.core.reflection.mock.objects.SimpleObject02;
import ca.ntro.core.reflection.mock.objects.TestObject01;
import ca.ntro.core.reflection.mock.objects.TestObject02;

public class ObjectGraphJsonTests {

	@Test
	public void testJsonObjectGraph01() {
		SimpleObject02 o = new SimpleObject02();
		
		o.setAttr01("attr01");
		o.setAttr02(12);
		
		Ntro.factory().registerNamedClass(SimpleObject02.class);

		ObjectGraph graph = Ntro.reflection().graphFromObject(o);
		JsonObject jsonObject = graph.buildJsonObject();
		
		ObjectGraph jsonGraph = Ntro.reflection().graphFromJsonObject(jsonObject, "SimpleObject02_json");
		jsonGraph.write(Ntro.graphWriter());

	}

	@Test
	public void testObjectGraph01() {
		
		TestObject01 o = new TestObject01();

		Ntro.factory().registerNamedClass(TestObject01.class);
		Ntro.factory().registerNamedClass(TestObject02.class);

		ObjectGraph graph = Ntro.reflection().graphFromObject(o);
		JsonObject jsonObject = graph.buildJsonObject();
		
		ObjectGraph jsonGraph = Ntro.reflection().graphFromJsonObject(jsonObject, "TestObject01_json");
		jsonGraph.write(Ntro.graphWriter());

		TestObject01 clone = (TestObject01) jsonGraph.buildObject();
		graph = Ntro.reflection().graphFromObject(clone);
		
		List<Object> rootValues = new ArrayList<>();

		graph.startNodes().forEach(n -> {
			rootValues.add(n.object());
		});
		
		Ntro.asserter().assertTrue("Should contain " + clone, rootValues.contains(clone));
		Ntro.asserter().assertEquals(1, rootValues.size());
		
		List<Object> subValues = new ArrayList<>();

		graph.nodes().forEach(n -> {
			subValues.add(n.object());
		});
		
		Ntro.asserter().assertTrue("Should contain " + clone, subValues.contains(clone));
		Ntro.asserter().assertTrue("Should contain " + clone.getAttr01(), subValues.contains(clone.getAttr01()));
		//Ntro.asserter().assertEquals(2, subValues.size());
	}

	@Test
	public void testJsonObjectGraph02() {
		TestObject02 o = new TestObject02();
		
		Ntro.factory().registerNamedClass(TestObject01.class);
		Ntro.factory().registerNamedClass(TestObject02.class);
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(o);
		JsonObject jsonObject = graph.buildJsonObject();
		
		ObjectGraph jsonGraph = Ntro.reflection().graphFromJsonObject(jsonObject, "TestObject02_json");
		jsonGraph.write(Ntro.graphWriter());
		
		TestObject02 clone = (TestObject02) jsonGraph.buildObject();
		graph = Ntro.reflection().graphFromObject(clone);

		List<Object> subValues = new ArrayList<>();

		graph.nodes().forEach(n -> {
			subValues.add(n.object());
		});

		//Ntro.asserter().assertEquals(3, subValues.size());
		Ntro.asserter().assertTrue("Should contain", subValues.contains(clone));
		Ntro.asserter().assertTrue("Should contain", subValues.contains(clone.getTestObject01()));
		Ntro.asserter().assertTrue("Should contain", subValues.contains(clone.getTestObject01().getAttr01()));

	}

	@Test
	public void testObjectGraphJsonLinkedList01() throws Throwable {
		
		LinkedList<String> list = new MockLinkedList<>();

		Ntro.factory().registerNamedClass(MockLinkedList.class);
		Ntro.factory().registerNamedClass(MockLinkedListElement.class);
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(list);
		JsonObject jsonObject = graph.buildJsonObject();
		ObjectGraph jsonGraph = Ntro.reflection().graphFromJsonObject(jsonObject, "linkedList00_json");
		jsonGraph.write(Ntro.graphWriter());
		
		list.add("1");

		graph = Ntro.reflection().graphFromObject(list);
		jsonObject = graph.buildJsonObject();
		jsonGraph = Ntro.reflection().graphFromJsonObject(jsonObject, "linkedList01_json");
		jsonGraph.write(Ntro.graphWriter());

		list.add("2");

		graph = Ntro.reflection().graphFromObject(list);
		jsonObject = graph.buildJsonObject();
		jsonGraph = Ntro.reflection().graphFromJsonObject(jsonObject, "linkedList02_json");
		jsonGraph.write(Ntro.graphWriter());

	}

}
