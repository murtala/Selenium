package javaScriptExcecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor {
	
	private WebDriver driver;
	public JSExecutor(WebDriver driver) {
		this.driver = driver;
	}
	
	public void executeScript(String script){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(script+";");
	
	}

}
