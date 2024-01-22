package pageobjects;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseTest;
import fwutilities.ScreencaptureUtils;
import io.cucumber.java.Scenario;
import stepshelper.StepInitialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MpThreesPageObjects {
	
	
	WebDriver driver = null;
	BaseTest base = null;
	Scenario scenario = null;
	MpThreesPageObjects mpThreesPageObjects = StepInitialization.mpThreesPageObjects;
	ScreencaptureUtils screenstobj = new ScreencaptureUtils();
	public static Logger log = LoggerFactory.getLogger(MpThreesPageObjects.class);

	// Scenario scenario
	public MpThreesPageObjects(BaseTest base) {
		this.base = base;
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu']//a[contains(text(), 'MP3 Players')]")
	WebElement mpthreelink;
	
	@FindBy(xpath = "//*[@id='menu']//a[contains(text(), 'Show All MP3 Players')]")
	WebElement mpthreepath;
	
	String productnamelink =  "//*[@id='content']//a[contains(text(), '%s')]"; 
	String proddetName = "//h1[contains(text(), '%s')]";
	
	public void clickMPThreelink() {
		base.hoverVisiblePElementWE(mpthreelink);
		log.info("hovering the mpthreelink");
		base.clickVisiblePElementWE(mpthreepath);
		log.info("Clicking the mpthreelink");
	}
	
	public void clickMp3Name(String mp3name) {
		base.clickVisiblePElement(By.xpath(String.format(productnamelink, mp3name)));
		log.info("Clicking the mpthreelink to open it....");
		
	}
	
	public void verifyProductAttributes() {
		
	}
}
