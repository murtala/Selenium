package utilities.compareImage;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.compareImage.CompareImage;
import utilities.compareImage.CompareUtil;

public class ImageComparisonTest {

	private static ChromeDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File file = new File("../resources/chromedriver_win32/chromedriver.exe");
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath().replace("..", "src\\main"));
		//driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	//	driver.quit();
	}

	@Test
	public void test() throws Exception {
		
		File file1 = new File("G:/Users/Moortala/EclipseProjects/Selenium/src/main/resources/media/logo1.jpg");
		File file2 = new File("G:/Users/Moortala/EclipseProjects/Selenium/src/main/resources/media/logo2.jpg");
		String img1 =file1.getAbsolutePath().replace("..", "src\\main");
		String img2 =file2.getAbsolutePath().replace("..", "src\\main");
		CompareUtil.CompareImage(img1, img2);
		CompareImage.compare(file1, file2);
	}
}
