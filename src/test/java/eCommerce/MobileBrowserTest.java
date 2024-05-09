package eCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBaseClass2  {
@Test
		public void openbrowser() {
	//driver.get("http://google.com");
	//System.out.println(driver.getTitle());//get title of the page
	//driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
	//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
	driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
	
	//for scrolling in webbrowser in  mobile
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	String text=driver.findElement(By.cssSelector("a[href*='products/3']")).getText();//in CSS selector
	Assert.assertEquals(text, "Devops");
		}	
}
