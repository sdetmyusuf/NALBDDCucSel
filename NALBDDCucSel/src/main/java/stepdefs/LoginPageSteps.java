package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import pageobjects.LoginPageObjects;

public class LoginPageSteps {

	//Scenario scenario = null;
	BaseTest base = new BaseTest();
	LoginPageObjects loginpage = new LoginPageObjects(base);
	
	
	
	@Given("User opens the applicattion url")
	public void user_opens_the_applicattion_url() {
		loginpage.lclickMyAccount();
		loginpage.lclickLoginOption();
		
		System.out.println(">>>>>> user_opens_the_applicattion_url");
	    }
	
	//loginpage.
	
	
}
