package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import basepackage.BaseTest;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;

public class RegisterPageObjects {

	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;

	ScreencaptureUtils screenstobj = new ScreencaptureUtils();

	public RegisterPageObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
		// this.scenario = scenario;
	}

	@FindBy(xpath = "//h1[text()='Register Account']")
	private WebElement registerAccount;
	By registerContent = By.xpath("//h1[text()='Register Account']");
	By registerOption = By.xpath("//a[text()='Register']");
	By myaccount = By.xpath("//span[@class=\"hidden-xs hidden-sm hidden-md\" and text()='My Account']");
	By firstName = By.xpath("//input[@id=\"input-firstname\"]");
	By lastName = By.xpath("//input[@id='input-lastname']");
	By email = By.xpath("//input[@id='input-email']");
	By telephone = By.xpath("//input[@id='input-telephone']");
	By password = By.xpath("//input[@id='input-password']");
	By cpassword = By.xpath("//input[@id='input-confirm']");
	By agree = By.xpath("//input[@type='checkbox' and @name='agree']");
	By contn = By.xpath("//input[@type='submit' and @value='Continue']");
	By message = By.xpath("//div[@id='content']/h1");
	By errormsg = By.xpath("(//div[@id='account-register']//div)[1]");

	public void lclickMyAccount() {
		// WebElement register = driver.findElement(By.xpath("//span[@class=\"hidden-xs
		// hidden-sm hidden-md\" and text()='My Account']"));
		base.clickVisiblePElement(myaccount);
	}

	public void lclickRegisterOption() {
		base.clickVisiblePElement(registerOption);
	}

	public void verifyRegisterPage() {
		base.verifyIfElementPresent(registerContent, 15);
	}

	public void enterFname(String fname) {
		base.sendTextToInputBox(firstName, fname);
	}

	public void enterlname(String lname) {
		base.sendTextToInputBox(lastName, lname);
	}

	public void enteremail(String eml) {
		base.sendTextToInputBox(email, eml);
	}

	public void enterTelephone(String tphone) {
		base.sendTextToInputBox(telephone, tphone);
	}

	public void enterpassword(String pword) {
		base.sendTextToInputBox(password, pword);
	}

	public void enterCpassword(String conassword) {
		base.sendTextToInputBox(cpassword, conassword);
	}

	public void checkAgreeCheckBox() {
		base.clickVisiblePElement(agree);
	}

	public void clickContinue() {
		base.clickVisiblePElement(contn);
	}

	public boolean successMessage() {
		return base.verifyIfElementPresent(agree, 15);

	}
	public void checkMessage(String experrorMessage) {
		List<WebElement> error = driver.findElements(errormsg);
		List<WebElement> success = driver.findElements(message);
		if(error.size()>0) {
			String acterrorMsg = base.getElementText(errormsg);
			System.out.println(acterrorMsg);
			Assert.assertEquals(acterrorMsg, experrorMessage);
		}else if(success.size()>0) {
			String acterrorMsg = base.getElementText(message);
			System.out.println(acterrorMsg);
			Assert.assertEquals(acterrorMsg, experrorMessage);
		}
	}

}
