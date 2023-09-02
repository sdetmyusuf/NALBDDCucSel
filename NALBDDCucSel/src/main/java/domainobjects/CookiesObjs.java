package domainobjects;

import fwutilities.CookiesUtil;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class CookiesObjs {
	    private io.restassured.http.Cookies cookies;

	    public io.restassured.http.Cookies get() {
	        return cookies;
	    }

	    public void set(io.restassured.http.Cookies cookies) {
	        this.cookies = cookies;
	    }

	    public void injectToBrowser(WebDriver driver){
	        List<Cookie> seleniumCookies = new CookiesUtil().convertRACookiesToSelCookies(cookies);
	        int i = 0;
	        for(Cookie cookie: seleniumCookies){
	            System.out.println("COUNTER " + i + ": " + cookie.toString());
	            driver.manage().addCookie(cookie);
	            i++;
	        }
	        driver.navigate().refresh();
	    }
	}


