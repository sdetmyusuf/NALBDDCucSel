package pageobjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseTest;

public class BrokenLinksChecker {

	BaseTest base = null;
	WebDriver driver = null;

	public BrokenLinksChecker(BaseTest base) {

		this.base = base;
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	WebElement test;

	public List<WebElement> allLinksGetter() {

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr = allLinks.iterator();
		int respCode;

		while (itr.hasNext()) {

			String url = itr.next().getAttribute("href");

			try {
				HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode > 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return allLinks;

	}
}
