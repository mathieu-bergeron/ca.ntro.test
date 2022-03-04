package ca.ntro.core.demo.jdk;

import ca.ntro.core.NtroJdk;
import ca.ntro.core.demo.Demo;
import ca.ntro.core.initialization.InitializerOptions;
import ca.ntro.core.initialization.InitializerOptionsJdk;

public class ProdJdk {
	
	public static void main(String[] args) throws Throwable {

		InitializerOptions options = new InitializerOptionsJdk();
		options.setProd(true);
		
		NtroJdk.initializer()
		     .setOptions(options)
		     .executeBlocking();
		
		Demo.main();
	}
}
