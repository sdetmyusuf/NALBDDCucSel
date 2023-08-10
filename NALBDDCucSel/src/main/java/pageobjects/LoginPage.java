package pageobjects;

import org.openqa.selenium.WebDriver;

import basepackage.BaseTest;

public class LoginPage {
	
	BaseTest base = null;
	WebDriver driver = null;
	
	public LoginPage(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
		
	}

}
