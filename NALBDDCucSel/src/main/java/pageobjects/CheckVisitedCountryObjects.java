package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import basepackage.BaseTest;

public class CheckVisitedCountryObjects {

	BaseTest base = null;
	WebDriver driver = null;

	public void CheckVisitedCountryObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
	}
	
	String capitalXpath = "//td[contains(text(), '%s')]";
	
	public void checkCapital (String capitalName) {
		
		boolean isCapital = driver.findElements(By.xpath(String.format(capitalXpath, capitalName))).size()>0;
		if (isCapital) {
			
		}
	}

}
