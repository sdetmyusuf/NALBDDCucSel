package stepdefs;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import basepackage.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SubmitOpderObjects;
import stepshelper.StepInitialization;

public class SubmitOrderSteps {
	
	BaseTest base = StepInitialization.base;
	SubmitOpderObjects submitOpderObjects = StepInitialization.submitOpderObjects;

	@Given("user is on cart item list page")
	public void user_is_on_cart_item_list_page(DataTable dataTable) {
		
		Map<String, String> pagename = dataTable.asMap();
		System.out.println(pagename.get("pagename"));
		submitOpderObjects.verifyCartPage(pagename.get("pagename"));
	   
	}

	@When("user checks the vegetable to be the same as ordered")
	public void user_checks_the_vegetable_to_be_the_same_as_ordered(DataTable dataTable) {
		Map<String, String> vegdetails = dataTable.asMap();
		int rows = submitOpderObjects.getNuberOfRows();
		assertEquals(rows, vegdetails.get("Items"));
	}

	@Then("user checks quantity to be correct same as ordered")
	public void user_checks_quantity_to_be_correct_same_as_ordered(DataTable dataTable) {
	   
	}

	@Then("user checks total to be correct same as ordered")
	public void user_checks_total_to_be_correct_same_as_ordered(DataTable dataTable) {
	 
	}
}
