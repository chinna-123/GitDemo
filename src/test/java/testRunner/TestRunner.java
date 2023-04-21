package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)	// Just to say that these methods will run with cucumber features
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions" ,
		stepNotifications = true ,
		tags = "@PortalTest" ,
		plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cucumber.junit"})	
// "@RegTest or @SmokeTest"  --> It will trigger either with Reg or SmokeTest Scenarios are there
//"@RegTest and @SmokeTest"  --> It will trigger when both Reg and SmokeTest Scenarios are there
// It will look for tests only which have both Reg and Smoke tags are there.
// "@RegTest" --> It'll trigger only RegTest scenario
// "@SmokeTest" --> It'll trigger only SmokeTest scenario
// "not @SanityTest" --> Except SanityTest remaining Tests will execute...
public class TestRunner {
	
}
