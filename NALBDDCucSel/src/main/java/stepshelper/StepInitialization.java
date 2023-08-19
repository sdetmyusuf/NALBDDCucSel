package stepshelper;

import basepackage.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.CartPageObjects;
import pageobjects.LoginPage;
import pageobjects.LoginPageObjects;
import pageobjects.RegisterPageObjects;
import pageobjects.VegPurchaseObjects;

public class StepInitialization {

	public static LoginPageObjects loginPageObjs = null;
	public static RegisterPageObjects registerPageObjs = null;
	public static VegPurchaseObjects vegpurchaseObjects = null;
	public static LoginPage loginp = null;
	public static BaseTest base = null;
	public static Scenario scenario = null;
	public static CartPageObjects cartPageObj = null;

	@Before
	public void beforeMethod() {
		base = new BaseTest();
		loginp = new LoginPage(base);
		loginPageObjs = new LoginPageObjects(base);
		registerPageObjs = new RegisterPageObjects(base);
		vegpurchaseObjects = new VegPurchaseObjects(base);
		cartPageObj = new CartPageObjects(base);
	}

}
