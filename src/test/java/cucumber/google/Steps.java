package cucumber.google;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	private static WebDriver driver;
	
	@Given("^I am on Google$")
	public void I_visit_google(){
		File file = new File("../resources/chromedriver_win32/chromedriver.exe");
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath().replace("..", "src\\main"));
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
	
	@When("^I search for \"(.*)\"$")
	public void search_for(String query){
		WebElement element = driver.findElement(By.name("q"));
		//enter input
		element.sendKeys(query);
		//submit
		element.submit();
		GoogleSearch gs = new GoogleSearch();
	}
	
	@Then("^the page title should start with \"(.*)\"$")
	public void checkTitle(String title){
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver d) {
				
				return d.getTitle().toLowerCase().startsWith("cheese");
			}
		});
		System.out.println("TITLE RITE NOW: " + driver.getTitle());
		
		driver.quit();
	}
}
