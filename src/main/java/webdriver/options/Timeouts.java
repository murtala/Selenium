package webdriver.options;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class Timeouts {
	
	private WebDriver driver;
	public Timeouts(WebDriver driver) {
		this.driver = driver;
		driver.get("http://www.google.com");
	}
	public void HandleTimeouts(){
		driver.manage().timeouts();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	}

}
