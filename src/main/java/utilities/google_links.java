package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class google_links 
{

	public static void main(String[] args) throws Exception 
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		driver.findElement(By.name("btnG")).click();
		Thread.sleep(3000);
		
		System.out.println("========all the links in web page=============");
		List<WebElement> lst=driver.findElements(By.xpath("//a"));
		for(WebElement w : lst)
			System.out.println(w.getText());
		
		System.out.println("========links in specific area============");
		WebElement we=driver.findElement(By.id("brs"));
		lst=we.findElements(By.tagName("a"));
		for(WebElement w : lst)
			System.out.println(w.getText()+"  "+w.getAttribute("href"));
		
		System.out.println("==========links start with Selenium==========");
		lst=driver.findElements(By.xpath("//a[starts-with(.,'Selenium') or starts-with(.,'selenium')]"));
		for(WebElement w : lst)
			System.out.println(w.getText());
		
		
		System.out.println("==========links contain word  selenium and web==========");
		lst=driver.findElements(By.xpath("//a[contains(.,'Selenium') and contains(.,'Web')]"));
		for(WebElement w : lst)
			System.out.println(w.getText());
		
		
		
		
		
		
		

	}

}
