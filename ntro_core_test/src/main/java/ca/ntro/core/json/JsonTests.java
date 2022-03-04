package ca.ntro.core.json;

import org.junit.Test;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.tests.NtroTests;

public class JsonTests extends NtroTests {
	
	@Test
	public void json01() {
		String jsonString = "{\"12\":12}";
		
		JsonObject jsonObject = Ntro.json().fromJsonString(jsonString);
		
		Ntro.asserter().assertEquals(12, jsonObject.get("12"));
	}

	@Test
	public void jsonPrettyPrint() {
		String jsonString = "{\"12\":12, \"13\":13}";
		
		JsonObject jsonObject = Ntro.json().fromJsonString(jsonString);
		
		String jsonStringPrettyPrint = Ntro.reflection().toJsonObject(jsonObject).toJsonString(true);
		
		Ntro.asserter().assertTrue("contains \\t", jsonStringPrettyPrint.contains("\t") || jsonStringPrettyPrint.contains("  "));
		Ntro.asserter().assertTrue("contains \\n", jsonStringPrettyPrint.contains("\n"));
		
	}
}
