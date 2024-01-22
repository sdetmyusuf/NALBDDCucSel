package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basepackage.BaseTest;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;

public class GmailInboxObjects {
	
	
	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;
	ScreencaptureUtils screenstobj = new ScreencaptureUtils();
	
	public GmailInboxObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
	
	}
	
	By nextBtn = By.xpath("//*[@id='identifierNext']//span[contains(text(), 'Next')]");
	
	public void clickNextButton() {
		base.clickVisiblePElement(nextBtn);
		
	}
	
	

}
