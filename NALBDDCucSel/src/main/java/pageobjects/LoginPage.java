package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basepackage.BaseTest;

public class LoginPage {
	
	BaseTest base = null;
	WebDriver driver = null;
	
	public LoginPage(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
		
	}
	
	public void loginToDifferentEnvs() {
		
	}

	public void loginToApp(){
	//	base.sendTextToInputBox(By.xpath("//*[@id=\"input-email\"]"), )
	}
}
