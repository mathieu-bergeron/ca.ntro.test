package ca.ntro.core.reflection.object_graph;

import org.junit.BeforeClass;

import ca.ntro.core.initialization.InitializerTestJdk;
import ca.ntro.core.reflection.object_graph.JsonObjectBuilderTests;
import ca.ntro.core.reflection.object_graph.ObjectGraphJsonTests;

public class JsonObjectBuilderTestsJdk extends JsonObjectBuilderTests {

	@BeforeClass
	public static void initializeJdk() {
		InitializerTestJdk.initialize();
	}
}
