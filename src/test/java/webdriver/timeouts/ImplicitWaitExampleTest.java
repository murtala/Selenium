package webdriver.timeouts;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitExampleTest {

	private static ChromeDriver driver;

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
	public void testInteract() {
		ImplicitWaitExample iwe = new ImplicitWaitExample(driver);
		iwe.Interact();
	}

}
