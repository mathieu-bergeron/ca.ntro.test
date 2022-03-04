package ca.ntro.core.json;

import org.junit.BeforeClass;

import ca.ntro.core.initialization.InitializerTestJdk;

public class JsonTestsJdk extends JsonTests {

	@BeforeClass
	public static void initializeJdk() {
		InitializerTestJdk.initialize();
	}

}
