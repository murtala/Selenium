package forms;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {
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
	public void testInteractWithcheckBox() {
		CheckBox cb = new CheckBox(driver);
		cb.interactWithcheckBox();
		// Get the Checkbox as WebElement using it's value attribute
		WebElement airbags = driver.findElement(By.xpath("//input[@value='Airbags']"));

		// Check if its already selected? otherwise select the Checkbox by calling click() method
		if (!airbags.isSelected())
			airbags.click();

		// Verify Checkbox is Selected
		assertTrue(airbags.isSelected());

		// Check Checkbox if selected? If yes, deselect it by calling click() method
		if (airbags.isSelected())
			airbags.click();

		// Verify Checkbox is Deselected
		assertFalse(airbags.isSelected());
	}

}
