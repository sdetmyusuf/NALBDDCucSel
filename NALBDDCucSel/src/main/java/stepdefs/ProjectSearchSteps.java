package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ProjectSearchObjects;
import pageobjects.RegisterPageObjects;
import stepshelper.StepInitialization;


public class ProjectSearchSteps {
	
	
	BaseTest base = StepInitialization.base;
	ProjectSearchObjects projSearchObj = StepInitialization.productSearchObjs;
	
	
	@Given("user clicks on product links from {string} and {string}")
	public void user_clicks_on_product_links(String menulinkname, String productlink) {
		
		projSearchObj.clickProductLink(menulinkname, productlink);
	 
	}

	@When("user seaches the product with {string}")
	public void user_seaches_the_product_with(String productname) {
		projSearchObj.searchProductLink(productname);
	}

	@When("user clicks on add to cart button")
	public void user_clicks_on_add_to_cart_button() {
		
		projSearchObj.clickAddtoCart();
	}

	@Then("the product is added to the cart")
	public void the_product_is_added_to_the_cart() {
		projSearchObj.attributeValidation();
	}

}
