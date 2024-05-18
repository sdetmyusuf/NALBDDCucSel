package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AORegister;
import stepshelper.StepInitialization;

public class AORegisterStepDefs {
	
	BaseTest base = StepInitialization.base;
	AORegister aORegister = StepInitialization.aORegister;
	
	
	@Given("user clicks on Account tab")
	public void userclicksAccountTab () {
		aORegister.clickAccountTab();
	}
	
	@When("user enters the {string}, {string} and {string}")
	public void userEntersDetails (String userName, String email, String pword) {
		aORegister.enterRegistrationDetails(userName, email, pword);
	}
	
	@And("user clicks on submit button")
	public void userClicksSubmit () { 
		aORegister.clickSubmitButton();
	}
	
	@Then("user registeration is completed for the {string}")
	public void verifyUserRegistration (String userName) {
		if (aORegister.checkUserRegistered(userName)) { 
			System.out.println("User is registered succesfully");
		}
	}
	

}
