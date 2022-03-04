package ca.ntro.core.initialization;

import ca.ntro.core.services.ExceptionService;
import ca.ntro.core.services.ExceptionThrowerDefault;

public class InitializerTest {

	public static void initialize() {
		Ntro.registerExceptionThrower(new ExceptionThrowerDefault());
	}

	public static void registerExceptionThrower(ExceptionService exceptionThrower) {
		Ntro.registerExceptionThrower(exceptionThrower);
	}

	

}
