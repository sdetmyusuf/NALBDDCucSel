package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.en.Given;
import pageobjects.BrokenLinksChecker;
import stepshelper.StepInitialization;

public class BrokenLinksSteps {
	
	
	BaseTest base = StepInitialization.base;
	BrokenLinksChecker brokenLinksChecker = StepInitialization.brokenLinksChecker;
	
	
	
	@Given("user launches the page and check the broken links")
	public void user_launches_the_page_and_check_the_broken_links() {
		brokenLinksChecker.allLinksGetter();
	}

}
