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

public class ScrollDemoTest extends BaseClass {
	
	@Test
	public void longPressGesture() throws MalformedURLException, URISyntaxException, InterruptedException {

	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	//one way (when you know where to go)=google engine class for scroll until it saw the text(just need to change the text=WebView)
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Search View\"))"));
	
	//another way in base class	
	scrollToendAction();
	
	
	
		
}
}

