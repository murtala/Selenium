package webdriver.options;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class Ime {
	
	private WebDriver driver;
	public Ime(WebDriver driver) {
		this.driver = driver;
		driver.get("http://www.google.com");
	}
	public void HandleIme(){
		driver.manage().ime();
		String engine = null;
		driver.manage().ime().activateEngine(engine );
		driver.manage().ime().deactivate();;
		driver.manage().ime().getActiveEngine();
		driver.manage().ime().getAvailableEngines();
		driver.manage().ime().isActivated();		
	}

}
