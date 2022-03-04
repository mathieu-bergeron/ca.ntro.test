package ca.ntro.core.task_graphs.ttask_graphs.ttask_graph;


import org.junit.BeforeClass;
import org.junit.Test;

import ca.ntro.core.initialization.InitializerTest;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.services.ExceptionThrowerMock;
import ca.ntro.core.task_graphs.task_graph.SimpleTask;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;
import ca.ntro.core.task_graphs.task_graph.TaskGroup;

public class TTaskGraphTests {
	
	protected ExceptionThrowerMock registerMockExceptionThrower() {
		ExceptionThrowerMock exceptionThrowerMock = new ExceptionThrowerMock();

		InitializerTest.registerExceptionThrower(exceptionThrowerMock);

		return exceptionThrowerMock;
	}

	@BeforeClass
	public static void initialize() {
		InitializerTest.initialize();
	}
	
	@Test
	public void ttaskGraphTest01() {
		
		TaskGraph graph = TaskGraph.newGraph();
		graph.setGraphName("ttaskGraphTest01");

		TaskGroup group01 = graph.newGroup("01");
		TaskGroup groupAB = graph.newGroup("AB");
		
		group01.addGroup(groupAB);

		SimpleTask taskA = groupAB.newTask("A");
		SimpleTask taskB = groupAB.newTask("B");
		SimpleTask taskC = group01.newTask("C");

		taskA.addNextTask(taskB);
		groupAB.addNextTask(taskC);
		
		graph.write(Ntro.graphWriter());
	}
}
