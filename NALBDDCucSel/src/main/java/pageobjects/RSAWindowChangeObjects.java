package pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basepackage.BaseTest;
import specs.applications.xpaths.RSAWebPage;

public class RSAWindowChangeObjects implements RSAWebPage{
	
	WebDriver driver = null;
	BaseTest base = null;
	
	public RSAWindowChangeObjects (BaseTest base) {
		this.base = base;
		this.driver = base.driver;
	}
	
	public void verifyPageRSA () {
		String pageTitle = base.getCurrentPageTitle();
		if (pageTitle.equalsIgnoreCase("Practice Page")) {
			System.out.println("The correct page is opened");
		}
	}
	
	public void moveToAnotherOrigin () {
		String curWindowHandle = driver.getWindowHandle();
		System.out.println(curWindowHandle);
		
		base.clickVisiblePElement(By.xpath(openTabBtn));
		Set<String> newWindowHandle = driver.getWindowHandles();
        String[] handlesArray = newWindowHandle.toArray(new String[newWindowHandle.size()]); 

		System.out.println(newWindowHandle.size());
		System.out.println(newWindowHandle);
		driver.switchTo().window(handlesArray[1]);
		base.clickVisiblePElement(aboutUsLink);
		
		
	}
	
	public void verifyAboutUs () {
		
		base.clickVisiblePElement(aboutUsContent);
		System.out.println(base.getElementText(aboutUsContent));
		Set<String> newWindowHandle = driver.getWindowHandles();
        String[] handlesArray = newWindowHandle.toArray(new String[newWindowHandle.size()]); 
		driver.switchTo().window(handlesArray[0]);
		
	}
	
	
	
	

}
