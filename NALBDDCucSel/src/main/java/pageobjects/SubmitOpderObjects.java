package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basepackage.BaseTest;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;

public class SubmitOpderObjects {
	
	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;
	VegPurchaseObjects vegPurchaseObjects = new VegPurchaseObjects(base);
	ScreencaptureUtils screenstobj = new ScreencaptureUtils();
	

	// Scenario scenario
	public SubmitOpderObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
	}
	
	By numberOfRows = By.xpath("//table[@id='productCartTables']//b[text() = 'Product Name']//ancestor::thead//following-sibling::tbody//tr");
	By productName = By.xpath("//p[@class='product-name']");
	
	public int getNuberOfRows() {
		List<WebElement> rows = driver.findElements(numberOfRows);
		int numOfRows = rows.size();
		return numOfRows;
	}
	
	
	
	
	
	
}
