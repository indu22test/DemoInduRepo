package rahulshettyacademy.AppiumProj;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigAppium() throws MalformedURLException, URISyntaxException {
		
		//to start the server and appium service
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\rajes\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.96").usingPort(4723).build();
		service.start();
		
		//driver for appium/automation on android device
		UiAutomator2Options options = new UiAutomator2Options();
		
		
		
		//setting the device name
		options.setDeviceName("induemulator");
		
		//setting the chromedriver path
		//options.setChromedriverExecutable("chrome.exe path");
		
		//code for ApiDemos app
		//options.setApp("C:\\Users\\rajes\\Desktop\\MobileTesting\\AppiumProj\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		//code for Apk General App
		options.setApp("C:\\Users\\rajes\\Desktop\\MobileTesting\\AppiumProj\\src\\test\\java\\resources\\General-Store.apk");
		
	    driver = new AndroidDriver(new URI("http://192.168.1.96:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
		//long press action(native app)
		public void LongpressAction(WebElement people) {
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) people).getId(),"duration",2000));
		}
		
		
		//scroll action(native app)
		public void scrollToendAction() {			
			//another way of scrolling=how much you want to scroll, need to give coordinates, it is not based upon the element or text where you want to scroll
			//also you can put do while loop if you want to scroll till the end when there is no scope of scrolling
			boolean canScrollMore;
			do
			{
				canScrollMore=(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
			
			}while(canScrollMore);						
		}
	
		//Swipe action(native app)
		public void swipeaction(WebElement firstimage, String direction) {
			
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) firstimage).getId(),
				    "direction", "left",
				    "percent", 0.25
				));
		}
	
		// sub string fpr Total purchase amount
		
		public Double getformattedAmount (String amount) {
			
			
			Double price=Double.parseDouble(amount.substring(1));
			return price;
			
		}
		
		
		
		
		
		
	@AfterClass
	public void tearDown() {
	    //closing the driver
	    driver.quit();
	    //closing the server
       service.stop();
		
		
		
	}
	
}
