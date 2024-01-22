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
	By emailinput = By.xpath("//*[@id='input-email']");
	By gmailemailinbox = By.xpath("//*[@id='identifierId']");
	By gamilnextbtn = By.xpath("//*[@id='identifierNext']//span[contains(text(), 'Next')]");
	By nalpassword = By.xpath("//*[@id=\"input-password\"]");
	By gmailpwd = By.xpath("//*[@id='password']//input[@type = 'password']");
	By loginBtnnal = By.xpath("//input[@type='submit']");
	By loginBtngmail = By.xpath("//*[@id='passwordNext']//span");
	
	@When("User enters email address {string}")
	public void user_enters_email_address(String emailadd) {
//		loginpage.lverifyLogo();
//		loginpage.lclickMyAccount();
//		loginpage.lclickLoginOption();
		base.sendTextToInputBox(gmailemailinbox, emailadd);
		
		System.out.println(">>>>>> user_opens_the_applicattion_url");  
	}
	
	
	@When("Enter valid password {string}")
	public void enter_valid_password(String password) {
		
		base.sendTextToInputBox(gmailpwd, password);
		System.out.println(">>>>>> enter_valid_password===> "+password); 
	}
	
	
	@When("clicks login button")
	public void clicks_login_button() {
		//WebElement element = base.driver.findElement(By.xpath("//input[@type='submit']"));
		base.scrollToPElement(loginBtngmail);
		base.clickVisiblePElement(loginBtngmail);
		System.out.println(">>>>>> clicks_login_button");
	}
	
	@Then("User should get logged in successfully")
	public void user_should_get_logged_in_successfully() {
		System.out.println(">>>>>> user_should_get_logged_in_successfully");
	}

}
