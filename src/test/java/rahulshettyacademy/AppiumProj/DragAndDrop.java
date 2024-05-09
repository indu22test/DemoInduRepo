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

public class DragAndDrop extends BaseClass {
	
	@Test
	public void DraganddropTest() throws MalformedURLException, URISyntaxException, InterruptedException {

	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	WebElement dragele=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) dragele).getId(),
		    "endX", 625,
		    "endY", 562
		));
	Thread.sleep(3000);
	String result=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
	
	//Assert.assertEquals(result, "Dropped!");
	
	
	
}
}

