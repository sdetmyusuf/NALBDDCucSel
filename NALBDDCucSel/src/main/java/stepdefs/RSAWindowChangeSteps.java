package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CartPageObjects;
import pageobjects.RSAWindowChangeObjects;
import pageobjects.VegPurchaseObjects;
import stepshelper.StepInitialization;

public class RSAWindowChangeSteps {
	
	BaseTest base = StepInitialization.base;
	RSAWindowChangeObjects rsaWindowChangeObjects = StepInitialization.rsaWindowChangeObjects;
	VegPurchaseObjects vegpurchase = StepInitialization.vegpurchaseObjects;
	
	@Given("user lanches the RSA url")
	public void user_lanches_the_rsa_url() {
		rsaWindowChangeObjects.verifyPageRSA();
	}

	@When("he clicks on the button which opens in new domain")
	public void he_clicks_on_the_button_which_opens_in_new_domain() {
	   rsaWindowChangeObjects.moveToAnotherOrigin();
	}

	@Then("user should be able to work in another domain also")
	public void user_should_be_able_to_work_in_another_domain_also() {
		rsaWindowChangeObjects.verifyAboutUs();
	}

}
