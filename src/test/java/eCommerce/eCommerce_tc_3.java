package eCommerce;

import java.time.Duration;
import java.util.Iterator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import rahulshettyacademy.AppiumProj.BaseClass;

public class eCommerce_tc_3 extends BaseClass{
	@Test
	
	
	public void fillform() throws InterruptedException {
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("indu");
		
		//for hiding keyboard
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Brazil\"))")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
				
		
		//to  add first and second item
		//one way
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//another way
		//driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART'][1]")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART'][1]")).click();
		
			
	
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
		
		
		//to check the page title with some wait until the text is visible(Explicit wait)
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		
		
		//to add the total
		//putting all the cart items prices in List to get the total size
		List<WebElement> productprices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int Count = productprices.size();
		double Totalsum =0;
		
		for (int i = 0; i < Count; i++) {
			String amountString= productprices.get(i).getText();
			//for removing the $ sign from $160string, using substring method
			//convert String into Double datatype for adding the values
			//will get the price in Double Datatype
			Double price = Double.parseDouble(amountString.substring(1));
			//add all the prices
			Totalsum = Totalsum +price;	
			//System.out.println(Totalsum);
		}
		
		String displaySum =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum =  getformattedAmount(displaySum);
		//System.out.println(displaySum);
		Assert.assertEquals(Totalsum, displayFormattedSum);
		
		//long press
		WebElement ele= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));	
		LongpressAction(ele);
		
		
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
		
		//now we are on web browser
		//Hybrid-Google page
		
		
		
	}
	
	
	
	
	

}
