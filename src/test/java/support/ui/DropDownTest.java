package support.ui;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	//driver= new FirefoxDriver();
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
	public void testUseDropDownMenu() {
		DropDown dd = new DropDown(driver);
		Select select =dd.useDropDownMenu();
		
		System.out.println("size " + select.getOptions().size());
		System.out.println("options " + select.getOptions());

		// select visible text
		select.selectByVisibleText("Saab");
		select.selectByValue("fiat");
		//slect by index number
		select.selectByIndex(3);
		//get the first selected value
		System.out.println("val" +select.getFirstSelectedOption());
		
		List<WebElement> collection = select.getOptions();
		
		for (int i=0; i< collection.size(); i++){
			System.out.println(collection.get(i).getText());
		}		
	}

}
