package webdriver.navigation;

import org.openqa.selenium.WebDriver;

public class NavigationExample {
	WebDriver driver;
	
	public NavigationExample(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigate(){
			driver.navigate().to("http://www.yahoo.com");
			driver.navigate().refresh();
			driver.navigate().back();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.navigate().forward();
		}

}
