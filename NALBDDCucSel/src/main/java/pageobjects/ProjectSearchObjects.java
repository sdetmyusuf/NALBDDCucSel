package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;

import basepackage.BaseTest;
import fwutilities.Log;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;

public class ProjectSearchObjects {

	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;

	ScreencaptureUtils screenstobj = new ScreencaptureUtils();

	public ProjectSearchObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
		// this.scenario = scenario;
	}

	String laplink = "//a[contains(text(), '%s')]";
	String menulink = "//*[@id='menu']//a[contains(text(),'%s')]";
	By searchbox = RelativeLocator.with(By.xpath("//*[@id='search']/input"));
	By searchbtn = By.xpath("//*[@id='search']/span/button");
	By addtocartbtn = By.xpath("//button//span[contains(text(), 'Add to Cart')]");
	
	String attributes = "//h1[contains(text(), 'HP LP3065')]//following-sibling::ul[1]//li[%s]";

	public void clickProductLink(String menulinkname, String productlink) {
		base.hoverVisiblePElement(String.format(menulink, menulinkname));
		base.clickVisiblePElement(By.xpath(String.format(laplink, productlink)));

	}

	public void searchProductLink(String productname) {
		base.sendTextToInputBox(searchbox, productname);
		base.clickVisiblePElement(searchbtn);

	}

	public void clickAddtoCart() {
		base.scrollToPElement(addtocartbtn);
		base.clickVisiblePElement(addtocartbtn);
		Log.info("Come on");
	}

//	public void attributeValidation() {
//		
//	}

	public void attributeValidation() {
		base.scrollToPElement(By.xpath("//h1[contains(text(), 'HP LP3065')]//ancestor::div[@class='col-sm-4']//li"));
		List<WebElement> prod_attributes = base.getElements(By.xpath("//h1[contains(text(), 'HP LP3065')]//following-sibling::ul[1]//li"));
		int numofattr = prod_attributes.size();
		System.out.println("Total attributes found=========>>>>>"+numofattr);
		ArrayList<String> prodattributes = new ArrayList<String>();
		for (int i = 0; i < numofattr; i++) {
			String attribute = base.getElementText(By.xpath(String.format(attributes, Integer.toString(i))));
			prodattributes.add(attribute);
		}
		
		
			System.out.println(prodattributes);
		
	}

}
