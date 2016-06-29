package samples.google.com;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.DependencyMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class GoogleHomeTest2 {

	WebDriver driver;
	GoogleHome gh;
	ArrayList<String> range;

	@BeforeClass
	public void beforeClass() {
		// instantiate variables, drivers
		driver = new FirefoxDriver();
		range = new ArrayList<String>();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test(priority = 1)
	public void GoogleHome() {
		gh = new GoogleHome(driver);
	}

	@Test(priority = 2)
	public void getTitle() {
		// verify title
		Assert.assertTrue(gh.getTitle().equalsIgnoreCase("google"));
	}

	@Test(priority = 3)
	public void search() { // initiate a search query
		String query = "hawaii";
		gh.search(query);
	}

	@Test(dependsOnMethods = { "search" })
	public void explore() { // get more info about my destination
		gh.images(); // open in new tab
		gh.maps(); // open in new
	}

	// get the data from the provider and put it in an arrayList for later manipulations
	@Test(dataProvider = "Price_Range")
	public void shopPrices(String ranges) {
		range.add(ranges);
	}

	@DataProvider(name = "Price_Range")
	public static String[][] minMaxRange() { // current price range is held
												// here.
		return new String[][] { { "50" }, { "500" } };
	}

	@Test(dependsOnMethods = { "shopPrices" }) 
	public void shop() {
		gh.shop(range);
	}

	@Test(dependsOnMethods = { "shop" }, priority = 9)
	// lowest priority, i want it to be last by all means
	public void viewOtherTabs() throws InterruptedException { // view other tabs
		Set<String> tabs = driver.getWindowHandles();

		driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL + "2");
		Thread.sleep(2000);
		driver.switchTo().window(tabs.iterator().next()); // switch to tab2
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL + "3");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}
}
