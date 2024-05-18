package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseTest;

public class AORegister {

	WebDriver driver = null;
	BaseTest base = null;
	public AORegister(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}
	
//	By accountOption = By.xpath("//li[@id='menu-item-1237']//a[contains(text(), 'Account')]");
	
	@FindBy(xpath = "//li[@id='menu-item-1237']//a[contains(text(), 'Account')]")
	WebElement accountOption;

	@FindBy(xpath = "//input[@id='reg_username']")
	WebElement inputUserName;

	@FindBy(xpath = "//input[@id='reg_email']")
	WebElement inputEmail;

	@FindBy(xpath = "//input[@id='reg_password']")
	WebElement inputPassword;

	@FindBy(xpath = "//button[contains(text(), 'Register')]")
	WebElement registerBtn;
	
	String greetingMsg = "//p[contains(text(), 'Hello')]//strong['%s']";
	
	public void clickAccountTab () { 
		base.clickVisiblePElementWE(accountOption);
	}

	public void enterRegistrationDetails(String userName, String email, String password) {
		base.sendTextToInputBoxwe(inputUserName, userName);
		base.sendTextToInputBoxwe(inputEmail, email);
		base.sendTextToInputBoxwe(inputPassword, password);
	}

	public void clickSubmitButton() {
		base.clickVisiblePElementWE(registerBtn);
	}
	
	public boolean checkUserRegistered (String userName) {
		boolean msgPresent = base.verifyIfElementPresent(By.xpath(toString().format(greetingMsg,userName )), 30);
		return msgPresent;
	}

}
