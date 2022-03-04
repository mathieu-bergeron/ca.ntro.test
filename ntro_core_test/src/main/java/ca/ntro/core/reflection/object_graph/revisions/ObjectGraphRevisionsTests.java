package ca.ntro.core.reflection.object_graph.revisions;

import org.junit.Test;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.mock.objects.TestCycle02;
import ca.ntro.core.reflection.mock.objects.TestList;
import ca.ntro.core.reflection.mock.objects.TestObject01;
import ca.ntro.core.reflection.mock.objects.TestObject02;
import ca.ntro.core.reflection.mock.objects.TestObjectCycle;
import ca.ntro.core.reflection.object_graph.ObjectGraph;
import ca.ntro.core.tests.NtroTests;

public class ObjectGraphRevisionsTests extends NtroTests {

	@Test
	public void graphRevisions01() {

		TestObject01 source = new TestObject01("FIXME) default constructor should not build a graph");
		ObjectGraph sourceGraph = Ntro.reflection().graphFromObject(source);

		TestObject01 target = new TestObject01();
		ObjectGraph targetGraph = Ntro.reflection().graphFromObject(target);
		
		Revisions revisions = sourceGraph.revisionsTo(targetGraph);

		TestObject01 empty = new TestObject01("FIXME) default constructor should not build a graph");

		ObjectGraph revisionsGraph = Ntro.reflection().graphFromObject(empty, "TestObject01_revisions");

		revisionsGraph.applyRevisions(revisions);

		revisionsGraph.write(Ntro.graphWriter());

		Ntro.asserter().assertTrue("applying revisions creates same graph ", revisionsGraph.graphEquals(sourceGraph));

	}

	@Test
	public void graphRevisions02() {

		TestObject01 source = new TestObject01();

		ObjectGraph sourceGraph = Ntro.reflection().graphFromObject(source);
		
		TestObject01 target = (TestObject01) sourceGraph.buildObject();
		
		ObjectGraph targetGraph = Ntro.reflection().graphFromObject(target);
		
		target.setAttr01("other");                                     // UPDATE
		target.getAttr04().get(0).get(0).getMap().put("key01", 'f');   // UPDATE
		target.getAttr04().get(0).get(0).getMap().remove("key02");     // DELETE
		target.getAttr04().get(0).get(0).getMap().put("key04", 'z');   // INSERT

		target.getAttr04().get(0).add(new TestObject02());             // INSERT OBJECT (inserts empty, then all revisions)
		
		Revisions revisions = sourceGraph.revisionsTo(targetGraph);
		
		revisions.forEach(revision -> {
			System.out.println(revision);
		});
		
		// FIXME: update not detected
		//        because we do not look for target nodes that
		//        are not in source
		Ntro.asserter().assertEquals(4, revisions.size());
	}
	
	@Test
	public void graphRevisions03() {
		
		TestCycle02 source = new TestCycle02();
		ObjectGraph sourceGraph = Ntro.reflection().graphFromObject(source, "TestCycle02_revisions");

		TestCycle02 target = new TestCycle02();
		target.setCycle(target);

		ObjectGraph targetGraph = Ntro.reflection().graphFromObject(target, "TestCycle02_target");

		Revisions revisions = sourceGraph.revisionsTo(targetGraph);
		
		sourceGraph.applyRevisions(revisions);
		sourceGraph.write(Ntro.graphWriter());
		
		System.out.println("\n\n\n");
		
		revisions.forEach(revision -> {
			System.out.println(revision);
		});

		System.out.println("\n\n\n");

		Ntro.asserter().assertEquals(2, revisions.size());
		
	}
	
	@Test
	public void graphRevisions04() {
		
		TestList source = new TestList();
		source.getList().add('a');
		source.getList().add('b');
		source.getList().add('c');

		ObjectGraph sourceGraph = Ntro.reflection().graphFromObject(source, "TestList_source");
		sourceGraph.write(Ntro.graphWriter());

		TestList target = new TestList();
		target.getList().add('0');
		target.getList().add('a');
		target.getList().add('b');
		target.getList().add('2');
		target.getList().add('c');

		ObjectGraph targetGraph = Ntro.reflection().graphFromObject(target, "TestList_target");
		targetGraph.write(Ntro.graphWriter());

		Revisions revisions = sourceGraph.revisionsTo(targetGraph);
		
		System.out.println("\n\n\n");
		
		revisions.forEach(revision -> {
			System.out.println(revision);
		});

		System.out.println("\n\n\n");

		Ntro.asserter().assertEquals(2, revisions.size());
		
		
		
		
	}
	
	
	


}
