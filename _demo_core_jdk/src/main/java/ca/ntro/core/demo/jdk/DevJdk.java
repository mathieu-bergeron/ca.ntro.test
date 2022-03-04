package ca.ntro.core.demo.jdk;

import ca.ntro.core.NtroJdk;
import ca.ntro.core.demo.Demo;

public class DevJdk {

	public static void main(String[] args) throws Throwable {

		NtroJdk.initializer().executeBlocking();

		Demo.main();
	}
}
