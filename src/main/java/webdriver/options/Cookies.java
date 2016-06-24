package webdriver.options;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class Cookies {
	
	private WebDriver driver;
	public Cookies(WebDriver driver) {
		this.driver = driver;
		driver.get("http://www.google.com");
	}
	public void HandleCookies(){
		Cookie cookie = new Cookie("name", "value");
		driver.manage().addCookie(cookie );
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("name");
		driver.manage().getCookieNamed("name");
	}

}
