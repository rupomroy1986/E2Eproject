package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//no need if u want to use the cucumber with testNg
//to run the test with maven just give mvn test in cmd it will run the file based on the testng xml file privuded.
//@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/features",glue="stepDefinations")

public class testRunner extends AbstractTestNGCucumberTests{

}