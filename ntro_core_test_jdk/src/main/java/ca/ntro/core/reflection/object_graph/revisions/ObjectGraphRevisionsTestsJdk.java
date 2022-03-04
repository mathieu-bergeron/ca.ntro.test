package ca.ntro.core.reflection.object_graph.revisions;

import org.junit.BeforeClass;

import ca.ntro.core.initialization.InitializerTestJdk;

public class ObjectGraphRevisionsTestsJdk extends ObjectGraphRevisionsTests {

	@BeforeClass
	public static void initializeJdk() {
		InitializerTestJdk.initialize();
	}

}
