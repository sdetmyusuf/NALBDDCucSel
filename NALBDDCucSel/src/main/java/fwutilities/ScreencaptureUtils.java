package fwutilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basepackage.BaseTest;
import io.cucumber.java.Scenario;

public class ScreencaptureUtils{
	
	StringUtils su = new StringUtils();

	public void screenshotCapturerFile(WebDriver driver) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshot = ts.getScreenshotAs(OutputType.FILE);

			String filePath = "C:\\Users\\Mohd Yusuf\\eclipse-workspace\\NALBDDCucSel\\target\\evidences\\screenshot_date.png";
			File targetFile = new File(filePath);

			FileUtils.copyFile(screenshot, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elementScreenCapture(By xpath, Scenario scenario) {
		WebElement element = BaseTest.driver.findElement(xpath);
		File filename =  element.getScreenshotAs(OutputType.FILE);
		
		String destFname = StringUtils.nameGenerator(scenario);
		
		try {
			FileUtils.copyFile(filename, new File("./screenshots/destFname.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void fullscrrenShot(WebDriver driver) {
		if (driver instanceof ChromeDriver) {
			File fullpae = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(fullpae, new File("./screenshots/fullpage.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void screenshotCapturerByte(Scenario scenario, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

		scenario.attach(screenshot, "image/png", scenario.getName());

	}

}
