package ca.ntro.core.reflection.object_graph;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.mock.objects.SimpleObject01;
import ca.ntro.core.reflection.mock.objects.SimpleObject02;
import ca.ntro.core.reflection.mock.objects.TestObject01;
import ca.ntro.core.reflection.mock.objects.TestObject02;
import ca.ntro.core.tests.NtroTests;

public class ObjectBuilderTests extends NtroTests {

	@Test
	public void objectBuilder01() {
		SimpleObject01 simpleObject = new SimpleObject01();
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(simpleObject);
		
		SimpleObject01 clone = (SimpleObject01) graph.buildObject();
		
		Ntro.asserter().assertEquals("attr01", clone.getAttr01());
		Ntro.asserter().assertEquals(12, clone.getAttr02());
	}

	@Test
	public void objectBuilder02() {
		SimpleObject02 simpleObject = new SimpleObject02("attr01", 12);
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(simpleObject);
		
		SimpleObject02 clone = (SimpleObject02) graph.buildObject();
		
		Ntro.asserter().assertEquals("attr01", clone.getAttr01());
		Ntro.asserter().assertEquals(12, clone.getAttr02());
	}

	@Test
	public void testObjectGraph01() {
		
		TestObject01 o = new TestObject01();
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(o);

		TestObject01 clone = (TestObject01) graph.buildObject();

		ObjectGraph cloneGraph = Ntro.reflection().graphFromObject(clone, "TestObject01_clone");
		cloneGraph.write(Ntro.graphWriter());
		
		List<Object> rootValues = new ArrayList<>();

		cloneGraph.startNodes().forEach(n -> {
			rootValues.add(n.object());
		});
		
		Ntro.asserter().assertTrue("Should contain " + o, rootValues.contains(clone));
		Ntro.asserter().assertEquals(1, rootValues.size());
		
		List<Object> subValues = new ArrayList<>();

		cloneGraph.nodes().forEach(n -> {
			subValues.add(n.object());
		});
		
		Ntro.asserter().assertTrue("Should contain " + clone, subValues.contains(clone));
		Ntro.asserter().assertTrue("Should contain " + clone.getAttr01(), subValues.contains(clone.getAttr01()));
		//Ntro.asserter().assertEquals(2, subValues.size());
	}

	@Test
	public void testObjectGraphClone02() {
		TestObject02 o = new TestObject02();
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(o);
		TestObject02 clone = (TestObject02) graph.buildObject();

		ObjectGraph cloneGraph = Ntro.reflection().graphFromObject(clone, "TestObject02_clone");
		cloneGraph.write(Ntro.graphWriter());
		
		List<Object> subValues = new ArrayList<>();

		cloneGraph.nodes().forEach(n -> {
			subValues.add(n.object());
		});

		
		//Ntro.asserter().assertEquals(3, subValues.size());
		Ntro.asserter().assertTrue("Should contain", subValues.contains(clone));
		Ntro.asserter().assertTrue("Should contain", subValues.contains(clone.getTestObject01()));
		Ntro.asserter().assertTrue("Should contain", subValues.contains(clone.getTestObject01().getAttr01()));
	}


}
