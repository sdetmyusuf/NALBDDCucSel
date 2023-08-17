package stepdefs;

import java.util.List;
import java.util.Map;

import basepackage.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPageObjects;
import pageobjects.RegisterPageObjects;
import stepshelper.StepInitialization;

public class RegisterPageSteps {
	
	//Scenario scenario = null;
		BaseTest base = StepInitialization.base;
		RegisterPageObjects registerPage = StepInitialization.registerPageObjs;
		
		@When("User navigates to register account page")
		public void user_navigates_to_register_account_page() {
			
			registerPage.lclickMyAccount();
			registerPage.lclickRegisterOption();
			registerPage.verifyRegisterPage();
		}	
		
		@When("User enters the values in all mandatory fields")
		public void user_enters_values_mandatory_fields(DataTable data){
			Map<String, String> map = data.asMap(String.class, String.class);
			registerPage.enterFname(map.get("fname"));
			registerPage.enterlname(map.get("lname"));
			registerPage.enteremail(map.get("emailaddress"));
			registerPage.enterTelephone(map.get("telephone"));
			registerPage.enterpassword(map.get("password"));
			registerPage.enterCpassword(map.get("password"));			
		}
		
		@And("User clicks privacy policy field")
		public void user_clicks_privacy_policy_field() {
			registerPage.checkAgreeCheckBox();
			
		}
		
		@And("User clicks on continue button")
		public void user_clicks_on_continue_button() {
			System.out.println(">>>User clicks on continue button");
			registerPage.clickContinue();
			
		}
		
		@Then("Account should be created with the message")
		public void account_should_be_created(DataTable datatable) {
			List<String> map = datatable.asList();
			String errorExpe = map.get(0);
			//String errorExpe = map.get("message");
			registerPage.checkMessage(errorExpe);
			
		}
		

}
