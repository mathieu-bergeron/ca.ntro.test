package ca.ntro.core.remplacement4d5;

import org.junit.BeforeClass;

import ca.ntro.core.initialization.InitializerTestJdk;

public class Remplacement4d5TestsJdk extends Remplacement4d5Tests {

	@BeforeClass
	public static void initializeJdk() {
		InitializerTestJdk.initialize();
	}
}
