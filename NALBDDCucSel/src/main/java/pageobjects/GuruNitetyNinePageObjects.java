package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basepackage.BaseTest;
import specs.applications.xpaths.Guru99TestPage;

public class GuruNitetyNinePageObjects implements Guru99TestPage{

	WebDriver driver = null;
	BaseTest base = null;

	public GuruNitetyNinePageObjects(BaseTest base) {
		this.base = base;
		driver = base.driver;
	}
	
	public void startQuiz (String email) {
		
		try {
			Thread.sleep(5000);
		
		base.scrollToPElement(header);
		
		WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
	//	base.driver.switchTo().frame("JotFormIFrame-210213466810445");
        Thread.sleep(5000);
		base.scrollToPElement(emailField);
		base.sendTextToInputBox(emailField, email);
		
		base.clickVisiblePElement(nextBtn);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
