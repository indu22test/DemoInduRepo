package rahulshettyacademy.AppiumProj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Longpress extends BaseClass {
	
	@Test
	public void longPressGesture() throws MalformedURLException, URISyntaxException, InterruptedException {

	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click(); 
	driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click(); 
	//long click gesture
	WebElement people=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	//code shift to base class
	//((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		   // "elementId", ((RemoteWebElement) people).getId(),"duration",2000));	
	LongpressAction(people);
	
	String menutext= driver.findElement(By.id("android:id/title")).getText();//to capture the title
	Assert.assertEquals(menutext, "Sample menu");//to verify the title
	Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());//to verify for display

		 
		
}
}

