package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepackage.BaseTest;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;

public class CartPageObjects {

	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;
	VegPurchaseObjects vegPurchaseObjects = new VegPurchaseObjects(base);
	ScreencaptureUtils screenstobj = new ScreencaptureUtils();
	

	// Scenario scenario
	public CartPageObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
	}

	By cartImage = By.xpath("//img[@alt = 'Cart']");
	By prodInfo = By.xpath("(//div[@class='product-info']/p[@class='product-name'])[1]");
	By prodQuant = By.xpath("(//div[@class='product-total']/p[@class = 'quantity'])[1]");
	By cartTotal = By.xpath("(//div[@class='product-total']/p[@class = 'amount'])[1]");
	By checkout = By.xpath("//div[@class='action-block']//button[contains(text(), 'PROCEED TO CHECKOUT')]");
	By checkEmptyCart = By.xpath("(//h2[contains(text(), 'You cart is empty!')])[1]");
	public void clickOnCart() {
		base.clickVisiblePElement(cartImage);
	}
	
	public boolean CheckifCartEmpty() {
		boolean isEmpty = (base.verifyIfElementPresent(checkEmptyCart, 5));
		return isEmpty;
	}

	public String getVegname() {
		String vegname = base.getElementText(prodInfo);
		return vegname;
	}

	public String getVegQuantity() {
		String vegQuantity = base.getElementText(prodQuant);
		return vegQuantity;
	}

	public String getCartTotal() {
		String carttotal = base.getElementText(cartTotal);
		return carttotal;
	}

	public void clickOnCheckout() {
		base.clickVisiblePElement(checkout);
	}

}
