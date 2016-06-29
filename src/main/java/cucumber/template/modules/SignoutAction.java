package cucumber.template.modules;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import cucumber.template.helpers.Log;
import cucumber.template.pageobjects.AutomationHomePage;



public class SignoutAction {

	public static void Execute(WebDriver driver) throws Exception{
		
		AutomationHomePage.sign_out.click();
		Log.info("Sign out is performed");

		Reporter.log("Sign out is performed");

	}
}
