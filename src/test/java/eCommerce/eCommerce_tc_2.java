package eCommerce;

import java.time.Duration;
import java.util.Iterator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import rahulshettyacademy.AppiumProj.BaseClass;

public class eCommerce_tc_2 extends BaseClass{
	@Test
	
	public void fillform() throws InterruptedException {
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("indu");
		
		//for hiding keyboard
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Brazil\"))")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))")).click();
		
		//for two or more elements are same on the page like (add to cart), use for loop
		
		int productcount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int i = 0; i < productcount ; i++) {
			String productName= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
		//to check the page title with some wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		
		
		String selectedproduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(selectedproduct, "Jordan 6 Rings");
		
	}
	
	
	
	
	

}
