package mouseEvents;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickTest {

	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File file = new File("../resources/chromedriver_win32/chromedriver.exe");
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath().replace("..", "src\\main"));
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void testPerformDoubleClick() {
		
		DoubleClick dc = new DoubleClick(driver);
		
		WebElement message  = dc.message;
		
		//Verify color is Blue
				assertEquals("rgba(0, 0, 255, 1)",message.getCssValue("background-color").toString());
				
				dc.performDoubleClick();
				//ok
				//Verify Color is Yellow
				assertEquals("rgba(255, 255, 0, 1)",message.getCssValue("background-color").toString());
				
	}

}
