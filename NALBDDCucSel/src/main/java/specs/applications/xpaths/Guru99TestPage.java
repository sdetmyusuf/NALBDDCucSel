package specs.applications.xpaths;

import org.openqa.selenium.By;

public interface Guru99TestPage {
	
	By header = By.xpath("//h2[contains(text(), 'Software Testing MCQ Online Test 1')]");
	By emailField = By.xpath("//*[@id='input_135']");
	By nextBtn = By.xpath("(//button[@id = 'form-pagebreak-next_132'])[1]");

}
