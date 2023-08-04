package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resource/features",
		glue = {"steps","cuchooks"},
		tags = "@all and not @regression and not @wip",
		//dryRun = true,
		plugin = {"pretty", 
				"html:target/CucumberReports/CucumberReport.html",
				"json:target/CucumberReports/CucumberReport.json",
				"junit:target/CucumberReports/CucumberReport.xml"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
