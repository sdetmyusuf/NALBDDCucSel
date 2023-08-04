package pageobjects;

import org.openqa.selenium.WebDriver;

import basepackage.BaseTest;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;

public class RegisterPageObjects {
	
	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;
	
	ScreencaptureUtils screenstobj = new ScreencaptureUtils();

	public RegisterPageObjects(BaseTest base, Scenario scenario) {
		this.base = base;
		driver = base.driver;
		this.scenario = scenario;
	}
	
	
	
	
	

}
