package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basepackage.BaseTest;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPageObjects;
import stepshelper.StepInitialization;

public class LoginPageSteps {

	//Scenario scenario = null;
	BaseTest base = StepInitialization.base;
	LoginPageObjects loginpage = StepInitialization.loginPageObjs;
	
	
	
	
	
	@When("User enters email address {string}")
	public void user_enters_email_address(String emailadd) {
		loginpage.lclickMyAccount();
		loginpage.lclickLoginOption();
		base.sendTextToInputBox(By.xpath("//*[@id=\"input-email\"]"), emailadd);
		
		System.out.println(">>>>>> user_opens_the_applicattion_url");  
	}
	
	
	@When("Enter valid password {string}")
	public void enter_valid_password(String password) {
		
		base.sendTextToInputBox(By.xpath("//*[@id=\"input-password\"]"), password);
		System.out.println(">>>>>> enter_valid_password===> "+password); 
	}
	
	
	@When("clicks login button")
	public void clicks_login_button() {
		WebElement element = base.driver.findElement(By.xpath("//input[@type='submit']"));
		base.scrollToPElement(element);
		base.clickVisiblePElement(By.xpath("//input[@type='submit']"));
		System.out.println(">>>>>> clicks_login_button");
	}
	
	@Then("User should get logged in successfully")
	public void user_should_get_logged_in_successfully() {
		System.out.println(">>>>>> user_should_get_logged_in_successfully");
	}

}
