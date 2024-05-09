package rahulshettyacademy.AppiumProj;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appiumbasics extends BaseClass {
	
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {

	    //start automation
	    //locators=xpath, and id for both web and mobile (use By)and accessibility and androidUiAutomation and className only for mobile(appiumBy)
		
	    driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	    driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
	    driver.findElement(By.id("android:id/checkbox")).click();
	    driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']")).click();
	    String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
	    Assert.assertEquals(alertTitle, "WiFi settings");
	    driver.findElement(By.id("android:id/edit")).sendKeys("indu");
	    //if className for two or more elements are same use with Index number
	    //driver.findElements(AppiumBy.className("android.widget.Button)[1]")).get(1).click();
	
	    driver.findElement(By.id("android:id/button1")).click();
	    
}
}