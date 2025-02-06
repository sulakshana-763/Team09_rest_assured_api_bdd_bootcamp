package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"src/test/java/stepDefinition_requests"})
public class Testrunner extends AbstractTestNGCucumberTests {

}
