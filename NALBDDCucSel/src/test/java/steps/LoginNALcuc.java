package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import datareaders.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginNALcuc {
	
	List<HashMap<String, String>> testData = new ArrayList<>();
	
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
	
	@Given("User launches browser")
	public void user_launches_browser() {
		System.out.println(">>>>>> user launches browser");
	}

	@Given("opens url {string}")
	public void opens_url(String string) {
		System.out.println(">>>>>> user opens url");
	}

	@When("User navigates to my account menu")
	public void user_navigates_to_my_account_menu() {
		System.out.println(">>>>>> User navigates to my account menu");
	}

	@When("click on login")
	public void click_on_login() {
		System.out.println(">>>>>> User clicks on login");
		Assert.assertEquals(false, true);
	}

	@Then("check user navigates to my account page by passing username passwprd from excel ror {string}")
	public void check_user_navigates_to_my_account_page_by_passing_username_passwprd_from_excel_ror(String rows) {
		testData = DataReader.data(System.getProperty("user.dir")+"\\TestData-FW\\TestData.xlsx", "Sheet1");
		try {		
		int index = Integer.parseInt(rows)-1;
		String username = testData.get(index).get("username");
		String pwd = testData.get(index).get("password");
		String reslt = testData.get(index).get("res");
		
		System.out.println(">>>>>> username read from excel>>>> "+username);
		System.out.println(">>>>>> password read from excel>>>> "+pwd);
		System.out.println(">>>>>> reslt read from excel>>>> "+reslt);
		}catch(NumberFormatException e) {
			
		}
		
		
		
		
	}
}