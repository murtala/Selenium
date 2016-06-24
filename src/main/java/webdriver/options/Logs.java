package webdriver.options;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;

public class Logs {
	private WebDriver driver;
	public Logs(WebDriver driver) {
		this.driver = driver;
		driver.get("http://www.google.com");
	}
	public void HandleLogs(){
		driver.manage().logs();
		String logType = null;
		driver.manage().logs().get(logType );
		Level level = Level.ALL;
		driver.manage().logs().get(logType).filter(level);
		driver.manage().logs().get(logType).getAll();
		driver.manage().logs().get(logType).iterator();
		driver.manage().logs().getAvailableLogTypes();
	}

}
