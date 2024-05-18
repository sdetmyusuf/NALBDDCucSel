package basepackage;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import fwutilities.PropertyFileReaderUtil;
import io.cucumber.java.Scenario;
import pageobjects.MpThreesPageObjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

	public static WebDriver driver;
	PropertyFileReaderUtil propobj = new PropertyFileReaderUtil();
	Properties prop = null;
	private boolean isBrowserLaunched = false;
	public static Logger log = LoggerFactory.getLogger(BaseTest.class);

	// Scenario scenario = null;

	public BaseTest() {

		prop = propobj.propFileReader(
				System.getProperty("user.dir") + "\\src\\main\\resources\\envconfig\\QA_config.properties");
		String browser = prop.getProperty("browser");
		launchBrowser(browser);
		// PageFactory.initElements(driver, this);
	}

	public WebDriver launchBrowser(String browser) {
		prop = propobj.propFileReader(
				System.getProperty("user.dir") + "\\src\\main\\resources\\envconfig\\QA_config.properties");
		browser = prop.getProperty("browser");

		switch (browser) {
		case "chrome":
			String chromepath = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\drivers\\chrome\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath);
			ChromeOptions chromeops = new ChromeOptions();
			chromeops.setBinary("C:\\Users\\Mohd Yusuf\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
			chromeops.addArguments("--remote-allow-orogins=*");
			chromeops.addArguments("start-maximized");
			driver = new ChromeDriver(chromeops);
			break;
		case "edge":
			EdgeOptions edgeoptions = new EdgeOptions();
			edgeoptions.addArguments("--remote-allow-orogins=*");
			edgeoptions.addArguments("start-maximized");
			driver = new EdgeDriver(edgeoptions);
			break;
		default:
			System.out.println("No browser");
		}

		String url = prop.getProperty("baseUrl");

		driver.get(url);
		log.info("Launching the "+browser+" browser");
		log.info("Application "+driver.getTitle()+" is opened....");
		isBrowserLaunched = true;

		return driver;

	}

	public void closeBrowser() {
		if (isBrowserLaunched) {
			driver.quit();
		}
	}

	public void waitForPageToLoad() {
		ExpectedCondition<Boolean> expCond = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("completed");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(expCond);
	}

	/*--------------------------------------------------------------------------------------------------
	 * applyFluentWait method using By xpath is used to apply Fluent Wait on that and return the element
	 * -------------------------------------------------------------------------------------------------*/
	public WebElement applyFluentWait(By xpath, String condition) {

		WebElement element = null;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
		
		switch (condition) {
		case "clickable":
			element = wait.until(ExpectedConditions.elementToBeClickable(xpath));
			break;
		case "visible":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
            break;
            
		default:
			System.out.println("Select some operations");
			break;
		}	
		
		return element;
			
	}

	/*----------------------------------------------------------------------------------
	 * getVisiblePageElement method using By xpath, to return the element
	 * -----------------------------------------------------------------------------------*/
	public WebElement getVisiblePageElement(By xpath) {
		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

		return element;
	}

	/* ------------------------------------------------------------------------------------
	  getVisiblePageElement method using String xpath, to return the element
	  ------------------------------------------------------------------------------------*/
	public WebElement getVisiblePageElement(String xpath) {
		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));

		return element;
	}

	/* -----------------------------------------------------------------------------------
	 * clickVisiblePElement method using By xpath, to return the element
	 * -----------------------------------------------------------------------------------*/
	public WebElement clickVisiblePElement(By xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpath)));
		driver.findElement(xpath).click();

		return element;

	}

	/* --------------------------------------------------------------------------------------
	 * clickVisiblePElement method using By xpath JSExcutor version, to return the element 
	 * --------------------------------------------------------------------------------------*/
	public WebElement clickVisiblePElementJSE(By xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		return element;

	}

	/* --------------------------------------------------------------
	 * clickVisiblePElement method using String xpath, to return the element
	 * ---------------------------------------------------------------*/
	public WebElement clickVisiblePElement(String xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));

		return element;

	}
		
	 /*-----------------------------------------------------------------------------------------------------
	  clickVisiblePElementWE method using WebElement is used to click a page element and return the element
	  -----------------------------------------------------------------------------------------------------*/
	public WebElement clickVisiblePElementWE(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();

		return element;

	}

	/* ---------------------------------------------------------------------------------
	 * hoverVisiblePElement method using By xpath, to return the element
	 * --------------------------------------------------------------------------------*/
	public WebElement hoverVisiblePElement(By xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		return element;

	}

	public WebElement hoverVisiblePElementWE(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(element));

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		return element;

	}

	/*-----------------------------------------------------------------------------------
	 * hoverVisiblePElement method using String xpath, to return the element
	 * --------------------------------------------------------------------------------*/
	public WebElement hoverVisiblePElement(String xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		return element;

	}

	/*-----------------------------------------------------------------------------------
	 * doubleClickVisiblePElement method using String xpath, to return the element
	 * -----------------------------------------------------------------------------------*/
	public WebElement doubleClickVisiblePElement(String xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));

		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick();

		return element;
	}

	/* -------------------------------------------------------------------------------------
	 * doubleClickVisiblePElement method using String xpath, to return the element
	 * ------------------------------------------------------------------------------------*/
	public WebElement doubleClickVisiblePElement(By xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));

		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick();

		return element;

	}

	/* ---------------------------------------------------------------------------------
	 * getElements using String xpath, to return the elements list
	 * ----------------------------------------------------------------------------------*/
	public List<WebElement> getElements(By xpath) {
		List<WebElement> listEle = driver.findElements(xpath);

		return listEle;
	}

	/* ------------------------------------------------------------------------------------
	 * applyImplicitWait method to wait for a specific amount of time
	 * ------------------------------------------------------------------------------------*/
	public void applyImplicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	/*------------------------------------------------------------------------------
	 * applyImplicitWait method to wait for a specific amount of time
	 * ----------------------------------------------------------------------------*/
	public boolean verifyIfElementPresent(By xpath, int time) {

		boolean flag = false;
		applyImplicitWait(time);
		try {
			flag = driver.findElement(xpath).isDisplayed();
		} catch (Exception e) {
			flag = false;
		}
		applyImplicitWait(time);

		return flag;
	}

	/*-------------------------------------------------------------------------------
	 * applyImplicitWait method to wait for a specific amount of time
	 * -----------------------------------------------------------------------------*/
	public WebElement dragDropElementPresent(By sourcexpath, By tarxpath) {
		WebElement selement = null;
		WebElement telement = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		selement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(sourcexpath)));
		telement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(tarxpath)));
		Actions action = new Actions(driver);

		action.dragAndDrop(selement, telement).perform();

		return selement;
	}

	/*---------------------------------------------------------------------------------
	 * sendTextToInputBox method to write some strings to input fields
	 * -------------------------------------------------------------------------------*/
	public WebElement sendTextToInputBox(By xpath, String text) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

		element.clear();
		element.sendKeys(text);

		return element;
	}
	
	/*---------------------------------------------------------------------------------
	 * sendTextToInputBox method to write some strings to input fields
	 * -------------------------------------------------------------------------------*/
	public WebElement sendTextToInputBoxwe(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(element));

		element.clear();
		element.sendKeys(text);

		return element;
	}


	public void scrollToPElement(By xpath) {
		WebElement element = driver.findElement(xpath);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
	}

	/*------------------------------------------------------------------------------- 
	 * getElementText method to get text in the form of strings to input fields
	 * ------------------------------------------------------------------------------*/
	public String getElementText(By xpath) {
		String text = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		text = wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath))).getText();
		return text;
	}

	public String getCurrentPageUrl() {
		String url = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		url = driver.getCurrentUrl();

		return url;
	}

	public String getCurrentPageTitle() {
		String title = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.urlContains(urlfractn));
		title = driver.getTitle();

		return title;
	}
	
	public WebElement pressEnterKey (By xpath) {
		
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

		element.clear();
		element.sendKeys(Keys.RETURN);

		return element;
		
	}

}
