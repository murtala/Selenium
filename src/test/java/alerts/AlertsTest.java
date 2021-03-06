package alerts;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertsTest {

	static WebDriver driver;
	static Alerts alert;

	@BeforeClass
	public static void beforeClass() {
		//DesiredCapabilities dc = new DesiredCapabilities();
	//	dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		driver = new FirefoxDriver();
		alert = new Alerts(driver);
	}

	@Test
	public void openAlert() {
		Alert al = alert.openAlert();
		// get the message from the alert
		Assert.assertEquals("Hello! I am an alert box!", al.getText());
		// accept the alert
		al.accept();
		// dismiss the alert
		alert.openAlert();
	    al.dismiss();
	}
	
	@Test
	public void testConfirmationBox() {
		Alert al = alert.confirmationBox();
		
		// get the message from the alert
	//	Assert.assertEquals("Hello! I am an alert box!", al.getText());
		Assert.assertEquals("Press a button!", al.getText());
		// accept the alert
		al.accept();
		// dismiss the alert
		alert.confirmationBox();
	    al.dismiss();
	}
	
	@Test
	public void testPrompt() {
		//get the prompt
		Alert al = alert.prompt();
		//get the input
		Assert.assertEquals("Please enter your name", al.getText());
		  //Enter some value on Prompt by calling sendKeys() method of Alert Class
  		al.sendKeys("Foo"); 
  		//accept
  		al.accept();
  	//Verify Page displays message with value entered in Prompt
		WebElement message = driver.findElement(By.id("prompt_demo"));
		Assert.assertEquals("Hello Foo! How are you today?", message.getText());
  		
		// dismiss the alert
		alert.prompt();
	    al.dismiss(); 		
	}
		
	@AfterClass
	public static void afterClass(){
		driver.close();
		driver.quit();
	}
	
}
