package interactions;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DragAndDropTest {

	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	driver.quit();
	}

	@Test
	public void testPerform() {
		DragAndDrop dnd = new DragAndDrop(driver);
		dnd.perform();
		
	}

}
