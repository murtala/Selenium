package support.ui;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectTest {

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
	public void testSelectMultiplesDropDowns() {
		MultiSelect ms = new MultiSelect(driver);
		
		ms.selectMultiplesDropDowns();
		// get the drop down menu
		Select color = new Select(driver.findElement(By.name("color")));
		
		//verify if multi select
		System.out.println(color.isMultiple());
		// get number of options
		color.getOptions().size();
		//Select multiple options in the list using visible text
		color.selectByVisibleText("Black");
		color.selectByVisibleText("Red");
		color.selectByVisibleText("Silver");
		
		//get all selected options
		List<WebElement> options = color.getAllSelectedOptions();
		for( WebElement option: options){
			
			System.out.println("selected: "+ option.getText());
		}
		
		
		//Deselect an option using visible text
		color.deselectByVisibleText("Silver");
		//Deselect an option using value attribute of the option
		color.deselectByValue("rd");
		//Deselect an option using index of the option
		color.deselectByIndex(0);
		//deselect everything
		color.deselectAll();
		
		
MultiSelect ms1 = new MultiSelect(driver);
		
		ms1.selectMultiplesDropDowns2();
		
		//Get the List as a Select using it's name attribute
 		color = new Select(driver.findElement(By.name("color")));
 		
 		//Verify List support multiple selection
    	assertTrue(color.isMultiple());
    	
    	//Verify List has five options for selection
    	assertEquals(5, color.getOptions().size());
    	
    	//Select multiple options in the list using visible text
    	color.selectByVisibleText("Black");
    	color.selectByVisibleText("Red");
    	color.selectByVisibleText("Silver");
    	
    	//Verify there 3 options selected in the list
    	assertEquals(3,color.getAllSelectedOptions().size());
    	
    	//We will verify list has multiple options selected as listed in a array
    	List<String> exp_sel_options = Arrays.asList(new String[]{"Black", "Red", "Silver"});
    	List<String> act_sel_options = new ArrayList<String>();
    	    	
    	for(WebElement option : color.getAllSelectedOptions())
    		act_sel_options.add(option.getText());
   	    	
    	//Verify expected array for selected options match with actual options selected
    	assertArrayEquals(exp_sel_options.toArray(),act_sel_options.toArray());
   		
    	//Deselect an option using visible text
    	color.deselectByVisibleText("Silver");
    	//Verify selected options count
    	assertEquals(2,color.getAllSelectedOptions().size());
    	
    	//Deselect an option using value attribute of the option
    	color.deselectByValue("rd");
    	//Verify selected options count
    	assertEquals(1,color.getAllSelectedOptions().size());
    	
    	//Deselect an option using index of the option
    	color.deselectByIndex(0);
    	//Verify selected options count
    	assertEquals(0,color.getAllSelectedOptions().size());
    	
    	/////////////////////////
    	//Get the Dropdown as a Select using it's name attribute
 		Select make = new Select(driver.findElement(By.name("make")));
 		
 		//Verify Dropdown does not support multiple selection
 		assertFalse(make.isMultiple());
 		//Verify Dropdown has four options for selection
    	assertEquals(4, make.getOptions().size());
    	
    	//We will verify Dropdown has expected values as listed in a array
    	List<String> exp_options = Arrays.asList(new String[]{"BMW", "Mercedes", "Audi","Honda"});
    	List<String> act_options = new ArrayList<String>();
    	
    	//Retrieve the option values from Dropdown using getOptions() method
    	for(WebElement option : make.getOptions())
    		 act_options.add(option.getText());
    	
    	//Verify expected options array and actual options array match
    	assertArrayEquals(exp_options.toArray(),act_options.toArray());
    	    	
    	//With Select class we can select an option in Dropdown using Visible Text
    	make.selectByVisibleText("Honda");
    	assertEquals("Honda", make.getFirstSelectedOption().getText());
    	
    	//or we can select an option in Dropdown using value attribute
    	make.selectByValue("audi");
    	assertEquals("Audi", make.getFirstSelectedOption().getText());
    	
    	//or we can select an option in Dropdown using index
    	make.selectByIndex(0);
    	assertEquals("BMW", make.getFirstSelectedOption().getText());
	}

}
