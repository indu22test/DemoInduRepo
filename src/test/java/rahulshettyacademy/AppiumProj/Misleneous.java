package rahulshettyacademy.AppiumProj;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
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
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Misleneous extends BaseClass {
	
	
	
	@Test
	public void misleneousTest() throws MalformedURLException, URISyntaxException {
		
		//if you want to directly land on one page
		//you should check in commandPromp = adb devices
		//go to emulator and open the desired page
		//go back to the terminal =adb shell dumpsys window | find "mCurrentFocus"
		//before the / , that will be app name and after the /, that will be package name
		//in javascript give key like intent and value like io......
		Activity activity =  new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				"intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
		
		
		
		//+++++++++++
		
	   // driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	   // driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
	    driver.findElement(By.id("android:id/checkbox")).click();
	    //+++++++++++++++
	    
	    //for rotate the device   
	    DeviceRotation landscape = new DeviceRotation(0, 0, 90);
	    driver.rotate(landscape);
	    
	    //+++++++++++++++
	    driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']")).click();
	    String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
	    Assert.assertEquals(alertTitle, "WiFi settings");
	    
	    //+++++++++++++++
	    //copy to clipboard-paste to clipboard    
	    driver.setClipboardText("indu");	    
	    driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	    driver.pressKey(new KeyEvent(AndroidKey.ENTER));//for next line
	    
	    //+++++++++++++++
	    driver.findElement(By.id("android:id/button1")).click();	    
	    
	    //+++++++++++++++
	    //KEYBOARD ACTIONS	    
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.HOME));
	    
	    
}
}