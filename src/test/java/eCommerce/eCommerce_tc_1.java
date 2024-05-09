package eCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import rahulshettyacademy.AppiumProj.BaseClass;

public class eCommerce_tc_1 extends BaseClass{
	@Test
	
	public void fillform() {
		
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("indu");
		
		//for hiding keyboard
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Brazil\"))")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//for toast massages=for android tag name should be like android.widget.Toast
		
		String toastmsg=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastmsg, "Please enter your name");
		
	}
	
	
	
	
	

}
