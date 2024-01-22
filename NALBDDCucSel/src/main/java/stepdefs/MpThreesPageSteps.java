package stepdefs;

import org.apache.logging.log4j.Logger;

import basepackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MpThreesPageObjects;
import pageobjects.ProjectSearchObjects;
import stepshelper.StepInitialization;

public class MpThreesPageSteps {
	
	
	BaseTest base = StepInitialization.base;
	MpThreesPageObjects mpThreesPageObjects = StepInitialization.mpThreesPageObjects;

	
	@Given("User moves to mp3 page")
	public void user_moves_to_mp3_page() {
		mpThreesPageObjects.clickMPThreelink();
	}

	@When("User searches the {string}")
	public void user_searches_the(String string) {

	}

	@Then("User is able to see the {string} on the page")
	public void user_is_able_to_see_the_on_the_page(String mp3name) {
		mpThreesPageObjects.clickMp3Name(mp3name);
	}

	@Then("user clicks on it and verifies its {string}")
	public void user_clicks_on_it_and_verifies_its(String string) {
		
	}


}

