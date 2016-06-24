package browser;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class CookiesTest {
	WebDriver driver = null;
  @Before
  public void beforeClass() {
	  
		System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");

		driver = new EdgeDriver();
		
		   EdgeOptions options = new EdgeOptions();
	        options.setPageLoadStrategy("eager");
	        driver = new EdgeDriver(options);

	     //   baseUrl = "http://www.microsoft.com/ja-jp/";
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
  }

  @After
  public void afterClass() {
	  driver.quit();
  }


  @Test
  public void handleCookies() {
	  driver.get("https://www.google.com/");
	  
	  //get cookies
	System.out.println("Cookies: "+ driver.manage().getCookies());

			// Now set the cookie. This one's valid for the entire domain
			Cookie cookie = new Cookie("CookieName", "value");
			/*Cookie cookie1 = new Cookie(name, value, path);
			Date expiry = new Date("today");
			Cookie cookie2 = new Cookie(name, value, path, expiry );
			Cookie cookie3 = new Cookie(name, value, domain, path, expiry, isSecure);*/
			
			//add a cookie
			driver.manage().addCookie(cookie);

			// get, search a specific cookie
			driver.manage().getCookieNamed("CookieName");
			driver.manage().getCookies().contains(cookie);
			
			//count cookies
			driver.manage().getCookies().size();
			
			
			// And now output all the available cookies for the current URL
			Set<Cookie> allCookies = driver.manage().getCookies();
			
			for (Cookie loadedCookie : allCookies) {
			    System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
			    System.out.println("getExpiry"+loadedCookie.getExpiry());
			    System.out.println("getDomain"+loadedCookie.getDomain());
			    System.out.println("getPath"+loadedCookie.getPath());
			    System.out.println("isSecure"+loadedCookie.isSecure());
			}
			
			// You can delete cookies in 3 ways
			// By name
			driver.manage().deleteCookieNamed("CookieName");
			// By Cookie
		//	driver.manage().deleteCookie(loadedCookie);
			// Or all of them
			driver.manage().deleteAllCookies();	
  }
}
