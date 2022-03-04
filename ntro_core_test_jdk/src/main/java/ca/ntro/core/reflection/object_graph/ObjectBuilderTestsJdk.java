package ca.ntro.core.reflection.object_graph;

import org.junit.BeforeClass;

import ca.ntro.core.initialization.InitializerTestJdk;
import ca.ntro.core.reflection.object_graph.ObjectBuilderTests;

public class ObjectBuilderTestsJdk extends ObjectBuilderTests {

	@BeforeClass
	public static void initializeJdk() {
		InitializerTestJdk.initialize();
	}
}
