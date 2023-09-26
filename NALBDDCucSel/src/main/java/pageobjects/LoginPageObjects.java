package pageobjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basepackage.BaseTest;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;

public class LoginPageObjects {

	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;
	
	ScreencaptureUtils screenstobj = new ScreencaptureUtils();
	
	public LoginPageObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
		//this.scenario = scenario;
		
//		if(!scenario.getSourceTagNames().contains("@NTE")) {
//			LoginToApp();
//		}
	}




	public void lverifyLogo() {
		
		boolean logoPresent = driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img")).isDisplayed();
		if (logoPresent) {
			System.out.println("We are login page, logon is there with text");
		}
	}

	public void lclickMyAccount() {
		driver.findElement(By.xpath("//span[@class=\"hidden-xs hidden-sm hidden-md\" and text()='My Account']"))
				.click();

	}

	public void lclickLoginOption() {
		driver.findElement(By.xpath("(//a[contains(text(), 'Login')])[1]")).click();
	}

	

	public void lclickWishlist() {
		driver.findElement(
				By.xpath("//i[@class='fa fa-heart']//following-sibling::span[contains(text(), 'Wish List')]")).click();

	}
	
	public void LoginToApp() {
		base.clickVisiblePElement(By.xpath("//span[@class=\"hidden-xs hidden-sm hidden-md\" and text()='My Account']"));
	}

}
