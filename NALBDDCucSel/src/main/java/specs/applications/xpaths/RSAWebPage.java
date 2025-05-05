package specs.applications.xpaths;

import org.openqa.selenium.By;

public interface RSAWebPage {
	
	String openTabBtn = "//*[@id='opentab']";
	By aboutUsLink = By.xpath("(//a[text()='About us'])[1]");
	By aboutUsContent = By.xpath("//*[@id='about-page']//h2");

}
