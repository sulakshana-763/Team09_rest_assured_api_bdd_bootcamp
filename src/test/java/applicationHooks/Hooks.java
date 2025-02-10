package applicationHooks;

import commonCode.Payload;
import io.cucumber.java.BeforeAll;
import utilities.ConfigReader;

public class Hooks {
	
	static ConfigReader reader = new ConfigReader();
	
	@BeforeAll
	public static void BeforeMethod() throws Throwable {
		System.out.println("You are in hooks");
		ConfigReader.loadConfig();
		Payload.loadTestCases();
	}
}
