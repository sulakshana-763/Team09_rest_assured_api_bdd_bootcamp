package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features={"src/test/resource/features"}, 
           glue = {"stepDefinition_requests"}
        
                          
		
)
public class TestRunner_junit {
	

}
