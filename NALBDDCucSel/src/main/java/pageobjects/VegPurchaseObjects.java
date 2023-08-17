package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basepackage.BaseTest;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;

public class VegPurchaseObjects {
	
	
	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;
	
	ScreencaptureUtils screenstobj = new ScreencaptureUtils();
	//Scenario scenario
	public VegPurchaseObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
	}

	String vegName = "//h4[contains(text(), '%s')]";
	String inputQuant = "//h4[contains(text(), '%s')]//following-sibling::div//input";
	String addtocart = "//h4[contains(text(), '%s')]//following-sibling::div//button";
	
	public void vegNameGetter(String inputVegname) {
		
		base.scrollToPElement(driver.findElement(By.xpath(String.format(vegName, inputVegname))));
		base.verifyIfElementPresent(By.xpath(String.format(vegName, inputVegname)), 15);
		
	}
	
	public void enterQunatity(String inputVegname, String qunat) {
		base.scrollToPElement(driver.findElement(By.xpath(String.format(inputQuant, inputVegname))));
		base.sendTextToInputBox(By.xpath(String.format(inputQuant, inputVegname)), qunat);
	}
	
	public void clickAddtoCart(String inputVegname) {
		base.scrollToPElement(driver.findElement(By.xpath(String.format(addtocart, inputVegname))));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		base.clickVisiblePElementJSE(By.xpath(String.format(addtocart, inputVegname)));
	}
		
}
