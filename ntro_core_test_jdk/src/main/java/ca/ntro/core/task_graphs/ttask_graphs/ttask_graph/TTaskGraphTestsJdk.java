package ca.ntro.core.task_graphs.ttask_graphs.ttask_graph;

import org.junit.BeforeClass;

import ca.ntro.core.initialization.InitializerTestJdk;
import ca.ntro.core.task_graphs.ttask_graphs.ttask_graph.TTaskGraphTests;

public class TTaskGraphTestsJdk extends TTaskGraphTests {

	@BeforeClass
	public static void initializeJdk() {
		InitializerTestJdk.initialize();
	}

}
