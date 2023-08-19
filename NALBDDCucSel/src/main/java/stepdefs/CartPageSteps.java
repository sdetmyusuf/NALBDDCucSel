package stepdefs;

import java.util.List;

import org.testng.Assert;

import basepackage.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.CartPageObjects;
import pageobjects.LoginPageObjects;
import pageobjects.VegPurchaseObjects;
import stepshelper.StepInitialization;

public class CartPageSteps {

	BaseTest base = StepInitialization.base;
	CartPageObjects cartPageObj = StepInitialization.cartPageObj;
	VegPurchaseObjects vegpurchase = StepInitialization.vegpurchaseObjects;
	
	@Given("user clicks on cart icon and checks if empty")
	public void user_clicks_on_cart_icon(DataTable datatable) {
		List<String> veg = datatable.asList();
		cartPageObj.clickOnCart();
		boolean isCartEmpty = cartPageObj.CheckifCartEmpty();
		if (isCartEmpty) {
			cartPageObj.clickOnCart();
			vegpurchase.vegNameGetter(veg.get(0));
			vegpurchase.enterQunatity(veg.get(0), veg.get(1));
			vegpurchase.clickAddtoCart(veg.get(0));
		}
	}

	@Then("user checks the vegetable name to on the cart")
	public void user_checks_to_be_correct_on_the_cart(DataTable datatable) {
		List<String> veg = datatable.asList();
		cartPageObj.clickOnCart();
		Assert.assertEquals(cartPageObj.getVegname(), veg.get(0));
		
	}

	@Then("user checks quantity to be correct on the cart")
	public void user_checks_quant_on_the_cart(DataTable datatable) {
		List<String> quant = datatable.asList();
		Assert.assertEquals(cartPageObj.getVegQuantity(), quant.get(0));
		
	}

	@Then("user checks total to be correct on the cart")
	public void user_checks_total_on_the_cart(DataTable datatable) {
		List<String> total = datatable.asList();
		Assert.assertEquals(cartPageObj.getCartTotal(), total.get(0));
		
	}

	@Then("user clicks checkout button")
	public void user_clicks_checkout_button() {

		cartPageObj.clickOnCheckout();

	}

}
