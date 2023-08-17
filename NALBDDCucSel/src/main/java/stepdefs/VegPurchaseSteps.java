package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.RegisterPageObjects;
import pageobjects.VegPurchaseObjects;
import stepshelper.StepInitialization;

public class VegPurchaseSteps {

	BaseTest base = StepInitialization.base;
	VegPurchaseObjects vegpurchase = StepInitialization.vegpurchaseObjects;

	@When("user enters the {string} of the vegetable to check availbility")
	public void user_enters_the_of_the_vegetable_to_check_availbility(String vegname) {
		vegpurchase.vegNameGetter(vegname);
	}

	@Then("user enters for {string} the {string}")
	public void user_enters(String vegname, String quantity) {
		vegpurchase.enterQunatity(vegname, quantity);
	}
	
	@Then("user clicks add to cart for {string}")
	public void userclicksAddtoCart(String vegname) {
		vegpurchase.clickAddtoCart(vegname);
	}
}
