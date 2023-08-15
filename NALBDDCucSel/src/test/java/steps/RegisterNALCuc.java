package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterNALCuc {
	
//	@When("User navigates to register account page")
//	public void user_navigates_to_register_account_page() {
//		System.out.println("User navigates to register account page");
//	}
//	
	@When("User enters first name {string} into first name field")
	public void user_enters_first_name_into_first_name_field(String fname) {
		System.out.println("User enters first name");
	}
	
	@And("User enters last name {string} into last name field")
	public void user_enters_last_name_into_last_name_field(String lname) {
		System.out.println("User enters last name \"yusuf\" into last name field");
	}
	
	@And("User enters email address {string} into email field")
	public void user_enters_email_address_into_email_field(String email) {
		System.out.println("User enters email address \"sdetmyusuf@gmail.com\" into email field");
	}

	@And("User enters telephone {string} into phone field")
	public void user_enters_telephone_into_phone_field(String phone) {
		System.out.println("User enters telephone \"1901234444\" into phone field");
	}
	
	@And("User enters password {string} into password field")
	public void user_enters_password_into_password_field(String pword) {
		System.out.println(">>>User enters password into password field");
		
	}
	
	@And("User enters password {string} into confirm password field")
	public void user_enters_password_into_cpassword_field(String pword) {
		System.out.println(">>>User enters password into confitm password field");
		
	}
//	@And("User clicks privacy policy field")
//	public void user_clicks_privacy_policy_field() {
//		System.out.println(">>>User clicks privacy policy field");
//		
//	}
	
	
//	@And("User clicks on continue button")
//	public void user_clicks_on_continue_button() {
//		System.out.println(">>>User clicks on continue button");
//		
//	}
	
	@And("Select yes for newsletter")
	public void select_yes_for_newsletter() {
		System.out.println(">>>Select yes for newsletter");
		
	}
	
	@When("User does not enter details into any field")
	public void user_does_not_enter_details_into_any_field(){
		System.out.println(">>>User does not enter details into any field");
	}
	
	@Then("Warning messages should be displayed for all the mandatory fields")
	public void warning_message_for_mandatory_fields() {
		System.out.println(">>>Warning messages should be displayed for all the mandatory fields");
		
	}
	
	@Then("Warning message about duplicate email address should be displayed")
	public void warning_message_for_duplicate_email() {
		System.out.println(">>>Warning message about duplicate email address should be displayed");
		
	}
	
//	@Then("Account should be created")
//	public void account_should_be_created() {
//		System.out.println(">>>Account should be created");
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}