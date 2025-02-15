package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features={"src/test/resource/features"}, 
           glue = {"stepDefinition_requests"},
		plugin = { "pretty", "html:target/cucumber-reports.html" }
        
                          
		
)
public class TestRunner_junit {
	

}
