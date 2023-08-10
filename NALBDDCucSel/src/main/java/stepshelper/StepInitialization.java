package stepshelper;

import basepackage.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.LoginPage;
import pageobjects.LoginPageObjects;
import pageobjects.RegisterPageObjects;

public class StepInitialization {

	public static LoginPageObjects loginPageObjs = null;
	public static RegisterPageObjects registerPageObjs = null;
	public static LoginPage loginp = null;
	public static BaseTest base = null;
	public static Scenario scenario = null;

	@Before
	public void beforeMethod() {
		base = new BaseTest();
		loginp = new LoginPage(base);
	}

}
