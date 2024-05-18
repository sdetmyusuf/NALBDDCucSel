package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.PurchaseStoreWise;
import pageobjects.SubmitOpderObjects;
import stepshelper.StepInitialization;

public class PurchaseStoreWiseSteps {

	BaseTest base = StepInitialization.base;
	PurchaseStoreWise purchaseStoreWise = StepInitialization.purchaseStoreWise;

	
	@When("user clicks on {string}")
	public void storeNameClick(String storeNameLink) {
		purchaseStoreWise.clickStoreLink(storeNameLink);
	}
	
	@Then("user is able to see the page with {string} opened")
	public void user_is_able_to_see_the_page_with_opened(String string) {
	   purchaseStoreWise.checkStoreName(string);
	}
	
	@When("user searches the {string}")
	public void user_searches_the(String productName) {
		purchaseStoreWise.searchProduct(productName);
	}
	@Then("user is able to see {string} enlisted there.")
	public void user_is_able_to_see_enlisted_there(String productName) {
		
		purchaseStoreWise.verifySearchProduct(productName);
	 
	}

}
