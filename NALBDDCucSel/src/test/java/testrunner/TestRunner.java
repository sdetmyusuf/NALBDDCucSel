package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		//features = {"C:\\Users\\Mohd Yusuf\\codeRepository\\NALCucSelBDD\\NALBDDCucSel\\src\\test\\resources\\features\\VegetablePurchase.feature", "C:\\Users\\Mohd Yusuf\\codeRepository\\NALCucSelBDD\\NALBDDCucSel\\src\\test\\resources\\features\\VegetableCart.feature"},
				//features = "@target/rerun.txt",
		glue = {"stepdefs","stepshelper", "cuchooks"},
		//tags = "@vegpurchase",
		tags = "@vegpurchase",
		//tags = "@all and not @regression and not @wip",
		//dryRun = true,
		plugin = {"pretty", 
				"html:target/CucumberReports/CucumberReport.html",
				"json:target/CucumberReports/CucumberReport.json",
				"rerun:target/rerun.txt",
				"junit:target/CucumberReports/CucumberReport.xml"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
