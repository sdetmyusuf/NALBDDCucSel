package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginNALcuc {
	@Given("User opens the applicattion url")
	public void user_opens_the_applicattion_url() {
		
		System.out.println(">>>>>> user_opens_the_applicattion_url");
	    }

	@When("User enters email address {string}")
	public void user_enters_email_address(String emailadd) {
		System.out.println(">>>>>> user_enters_email_address ====>>> "+emailadd);   
	}

	@When("Enter valid password {string}")
	public void enter_valid_password(String password) {
		System.out.println(">>>>>> enter_valid_password===> "+password); 
	}

	@When("clicks login button")
	public void clicks_login_button() {
		System.out.println(">>>>>> clicks_login_button");
	}

	@Then("User should get logged in successfully")
	public void user_should_get_logged_in_successfully() {
		System.out.println(">>>>>> user_should_get_logged_in_successfully");
	}

	@When("User enter invalid email address {string}")
	public void user_enter_invalid_email_address(String invEmailAdd) {
		System.out.println(">>>>>> user_enter_invalid_email_address===>>"+invEmailAdd);
	}

	@When("Enter invalid password {string}")
	public void enter_invalid_password(String invPasswword) {
		System.out.println(">>>>>> enter_invalid_password===>>>"+invPasswword);
	}

	@Then("User should get a proper warning message")
	public void user_should_get_a_proper_warning_message() {
		System.out.println(">>>>>> user_should_get_a_proper_warning_message");
	}

	@When("User enter valid email address {string}")
	public void user_enter_valid_email_address(String validEmailadd) {
		System.out.println(">>>>>> user_enter_valid_email_address ===>>>"+validEmailadd);
	}

	@When("User does not enter any credentials")
	public void user_does_not_enter_any_credentials() {
		System.out.println(">>>>>> user_does_not_enter_any_credentials");
	}
}