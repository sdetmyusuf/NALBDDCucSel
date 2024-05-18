package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basepackage.BaseTest;
import extentreports.ExtentReportEngine;
import io.cucumber.java.Scenario;

public class PurchaseStoreWise {

	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;
	ExtentReportEngine extentReportEngine = new ExtentReportEngine();

	public PurchaseStoreWise(BaseTest base) {

		this.base = base;
		this.driver = base.driver;

	}
	
	String streNamexp = "//a[text()='%s']";
	String storeHeader = "//h1[text() = '%s']";
	String productEnlisted = "//h1[text()='%s']";
	By searchBox = By.xpath("//input[@id='woocommerce-product-search-field-0']");
	By searchBtn = By.xpath("//button[text()='Search']");
	
	public void clickStoreLink(String storeNameLink) {
		base.clickVisiblePElement(By.xpath(String.format(streNamexp, storeNameLink)));
	}
	
	public void checkStoreName(String storeNameheaer) {
		base.clickVisiblePElement(By.xpath(String.format(storeHeader, storeNameheaer)));
	}
	
	public void searchProduct (String productName) {		
		base.sendTextToInputBox(searchBox, productName);
		base.clickVisiblePElement(searchBtn);
	}

	public boolean verifySearchProduct (String productName) {		
		boolean ifProductPresent = base.verifyIfElementPresent(By.xpath(String.format(productEnlisted, productName)), 30);
		extentReportEngine.extentReportSetUp();
		if (ifProductPresent) {
			return true;
		}
		return false;
	}
}
