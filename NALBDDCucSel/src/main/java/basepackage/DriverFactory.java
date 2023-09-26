//package basepackage;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//
//public class DriverFactory {
//
//	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//	public static WebDriver initializeWebdriver(String browser) {
//		WebDriver driver = null;
//
//		switch (browser) {
//		case "chrome":
//			ChromeOptions chromeops = new ChromeOptions();
//			chromeops.addArguments("--remote-allow-orogins=*");
//			chromeops.addArguments("start-maximized");
//			driver = new ChromeDriver(chromeops);
//			break;
//
//		case "edge":
//			EdgeOptions edgeoptions = new EdgeOptions();
//			edgeoptions.addArguments("--remote-allow-orogins=*");
//			edgeoptions.addArguments("start-maximized");
//			driver = new EdgeDriver(edgeoptions);
//			break;
//		default:
//			System.out.println("No browser");
//		}
//		DriverFactory.driver.set(driver);
//		return driver;
//	}
//
//	public static WebDriver getDriver() {
//		return driver.get();
//	}
//
//	public static void main(String[] args) {
//	//	WebDriver driver = DriverFactory.initializeWebdriver("chrome");
//		//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
//
//	}
//}
