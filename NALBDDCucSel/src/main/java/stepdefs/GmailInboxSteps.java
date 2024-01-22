package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.en.When;
import pageobjects.GmailInboxObjects;
import pageobjects.LoginPageObjects;
import stepshelper.StepInitialization;

public class GmailInboxSteps {
	
	BaseTest base = StepInitialization.base;
	GmailInboxObjects gmailInboxObjects = StepInitialization.gmailInboxObjects;
	
	@When("User click next button")
	public void user_click_next_button() {
		gmailInboxObjects.clickNextButton();
	}


}
