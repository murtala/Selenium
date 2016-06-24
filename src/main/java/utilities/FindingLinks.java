package utilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindingLinks {

	public void findAlllinks(WebDriver driver){
		//Get all the links displayed on Page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//Verify there are four links displayed on the page
	//	assertEquals(4, links.size());
		//Iterate though the list of links and print
		//target for each link
		for(WebElement link : links)
		System.out.println(link.getAttribute("href"));
	}
}
