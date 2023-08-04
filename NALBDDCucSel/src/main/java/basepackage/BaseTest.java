package basepackage;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fwutilities.PropertyFileReaderUtil;

public class BaseTest {

	public static WebDriver driver;
	PropertyFileReaderUtil propobj = new PropertyFileReaderUtil();
	Properties prop = null;
	private boolean isBrowserLaunched = false;

	public BaseTest() {

		launchBrowser();
	}

	public WebDriver launchBrowser() {
		ChromeOptions chromeops = new ChromeOptions();
		chromeops.addArguments("--remote-allow-orogins=*");
		chromeops.addArguments("start-maximized");
		driver = new ChromeDriver(chromeops);

		prop = propobj.propFileReader(
				"C:\\Users\\Mohd Yusuf\\eclipse-workspace\\NALBDDCucSel\\src\\main\\resource\\envconfig\\envdetails.properties");
		String url = prop.getProperty("url");

		driver.get(url);

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

	/*
	 * --------------------------------------------------------------
	 * getVisiblePageElement method using By xpath, to return the element
	 * ---------------------------------------------------------------
	 */
	public WebElement getVisiblePageElement(By xpath) {
		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

		return element;
	}

	/*
	 * --------------------------------------------------------------
	 * getVisiblePageElement method using String xpath, to return the element
	 * ---------------------------------------------------------------
	 */
	public WebElement getVisiblePageElement(String xpath) {
		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));

		return element;
	}

	/*
	 * --------------------------------------------------------------
	 * clickVisiblePElement method using By xpath, to return the element
	 * ---------------------------------------------------------------
	 */
	public WebElement clickVisiblePElement(By xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpath)));

		return element;

	}

	/*
	 * --------------------------------------------------------------
	 * clickVisiblePElement method using String xpath, to return the element
	 * ---------------------------------------------------------------
	 */
	public WebElement clickVisiblePElement(String xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));

		return element;

	}

	/*
	 * --------------------------------------------------------------
	 * hoverVisiblePElement method using By xpath, to return the element
	 * ---------------------------------------------------------------
	 */
	public WebElement hoverVisiblePElement(By xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		return element;

	}

	/*
	 * --------------------------------------------------------------
	 * hoverVisiblePElement method using String xpath, to return the element
	 * ---------------------------------------------------------------
	 */
	public WebElement hoverVisiblePElement(String xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		return element;

	}

	/*
	 * --------------------------------------------------------------
	 * doubleClickVisiblePElement method using String xpath, to return the element
	 * ---------------------------------------------------------------
	 */
	public WebElement doubleClickVisiblePElement(String xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));

		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick();

		return element;
	}

	/*
	 * --------------------------------------------------------------
	 * doubleClickVisiblePElement method using String xpath, to return the element
	 * ---------------------------------------------------------------
	 */
	public WebElement doubleClickVisiblePElement(By xpath) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));

		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick();

		return element;

	}

	/*
	 * -------------------------------------------------------------- 
	 * getElements using String xpath, to return the elements list
	 * ---------------------------------------------------------------
	 */
	public List<WebElement> getElements(String xpath) {
		List<WebElement> listEle = driver.findElements(By.xpath(xpath));

		return listEle;
	}
	
	/*
	 * -------------------------------------------------------------- 
	 * applyImplicitWait method to wait for a specific amount of time
	 * ---------------------------------------------------------------
	 */
	public void applyImplicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	/*
	 * -------------------------------------------------------------- 
	 * applyImplicitWait method to wait for a specific amount of time
	 * ---------------------------------------------------------------
	 */
	public boolean verifyIfElementPresent(By xpath, int time) {
		
		boolean flag = false;
		applyImplicitWait(time);
		try {
		flag = driver.findElement(xpath).isDisplayed();
		}catch(Exception e) {
			flag = false;
		}
		applyImplicitWait(time);
		
		return flag;
	}

}
