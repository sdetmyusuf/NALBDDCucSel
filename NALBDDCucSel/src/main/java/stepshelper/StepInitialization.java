package stepshelper;

import apis.UserApis;
import basepackage.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.AORegister;
import pageobjects.CartPageObjects;
import pageobjects.GmailInboxObjects;
import pageobjects.LoginPage;
import pageobjects.LoginPageObjects;
import pageobjects.MpThreesPageObjects;
import pageobjects.ProjectSearchObjects;
import pageobjects.PurchaseStoreWise;
import pageobjects.RegisterPageObjects;
import pageobjects.SubmitOpderObjects;
import pageobjects.VegPurchaseObjects;
import stepdefs.GmailInboxSteps;

public class StepInitialization {

	public static LoginPageObjects loginPageObjs = null;
	public static RegisterPageObjects registerPageObjs = null;
	public static VegPurchaseObjects vegpurchaseObjects = null;
	public static LoginPage loginp = null;
	public static BaseTest base = null;
	public static Scenario scenario = null;
	public static CartPageObjects cartPageObj = null;
	public static SubmitOpderObjects submitOpderObjects = null;
	public static ProjectSearchObjects productSearchObjs = null;
	public static MpThreesPageObjects mpThreesPageObjects =null;
	public static GmailInboxObjects gmailInboxObjects = null;
	public static UserApis userApis = null;
	public static PurchaseStoreWise purchaseStoreWise = null;
	public static AORegister aORegister = null;

	@Before
	public void beforeMethod() {
		base = new BaseTest();
		loginp = new LoginPage(base);
		loginPageObjs = new LoginPageObjects(base);
		registerPageObjs = new RegisterPageObjects(base);
		vegpurchaseObjects = new VegPurchaseObjects(base);
		cartPageObj = new CartPageObjects(base);
		submitOpderObjects = new SubmitOpderObjects(base);
		productSearchObjs = new ProjectSearchObjects(base);
		mpThreesPageObjects = new MpThreesPageObjects(base);
		gmailInboxObjects = new GmailInboxObjects(base);
		userApis = new UserApis();
		purchaseStoreWise = new PurchaseStoreWise(base);
		aORegister = new AORegister(base);
	}

}
