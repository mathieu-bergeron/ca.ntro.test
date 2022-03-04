package ca.ntro.core.reflection.object_graph;

import org.junit.Test;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.mock.objects.TestObject01;
import ca.ntro.core.reflection.mock.objects.TestObject02;
import ca.ntro.core.tests.NtroTests;

public class GraphEqualsTests extends NtroTests {

	@Test
	public void graphEquals01() {

		TestObject01 o = new TestObject01();
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(o);
		
		TestObject01 clone = (TestObject01) graph.buildObject();
		
		ObjectGraph cloneGraph = Ntro.reflection().graphFromObject(clone);

		Ntro.asserter().assertTrue("should be equal", cloneGraph.graphEquals(graph));
		Ntro.asserter().assertTrue("should be equal", graph.graphEquals(cloneGraph));
		Ntro.asserter().assertTrue("should be equal", graph.graphEquals(graph));
		
		clone.getAttr03().getTestObject01().setAttr01("other");

		Ntro.asserter().assertFalse("should not be equal", cloneGraph.graphEquals(graph));
		Ntro.asserter().assertFalse("should not be equal", graph.graphEquals(cloneGraph));

		o.getAttr03().getTestObject01().setAttr01("other");

		Ntro.asserter().assertTrue("should be equal", cloneGraph.graphEquals(graph));
		Ntro.asserter().assertTrue("should be equal", graph.graphEquals(cloneGraph));
		Ntro.asserter().assertTrue("should be equal", graph.graphEquals(graph));

		o.setAttr03(null);

		Ntro.asserter().assertFalse("should not be equal", cloneGraph.graphEquals(graph));
		Ntro.asserter().assertFalse("should not be equal", graph.graphEquals(cloneGraph));

	}

	@Test
	public void graphEquals02() {

		TestObject02 o = new TestObject02();
		
		ObjectGraph graph = Ntro.reflection().graphFromObject(o);
		
		TestObject02 clone = (TestObject02) graph.buildObject();
		
		ObjectGraph cloneGraph = Ntro.reflection().graphFromObject(clone);

		Ntro.asserter().assertTrue("should be equal", cloneGraph.graphEquals(graph));
		
		clone.getTestObject01().setAttr01("other");

		Ntro.asserter().assertFalse("should not be equal", cloneGraph.graphEquals(graph));
		
	}

}
