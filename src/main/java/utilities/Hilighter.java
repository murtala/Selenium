package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class Hilighter {
	private WebDriver driver;
	public Hilighter(WebDriver driver) {
		this.driver= driver;
	}
	public void hilightElement(WebElement element){
		for (int i = 0; i < 5; i++) {
	    	WrapsDriver wrappedElement = (WrapsDriver) element;
	    	JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
	    	driver.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                element, "color: green; border: 2px solid green;");
	    	driver.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                element, "");
	    }
	}

}
