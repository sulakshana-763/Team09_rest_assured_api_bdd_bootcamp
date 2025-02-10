package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue = {"stepDefinition_requests","Hooks"},
		features = {"src/test/resources/features/add_new_user.feature"},		
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class Testrunner extends AbstractTestNGCucumberTests {

}
