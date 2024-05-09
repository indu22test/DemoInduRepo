package eCommerce;

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

public class MobileBrowserBaseClass2 {

	public AppiumDriver driver;
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
		
		//setting the chromedriver path, for excusively native app this is not required, but for hybrid app it is required, and must for automation for mobile browser, and chromedrive version should me compatible with chrome browser version in your device
		//options.setChromedriverExecutable("C:\\Users\\rajes\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");//not working
		
		//open the chrome browser
		//need to run cmd command = (appium --allow-insecure chromedriver_autodownload)
		options.setCapability("browserName", "Chrome");//appium highly stable on chrome browser
		
	    driver = new AndroidDriver(new URI("http://192.168.1.96:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
		
		// sub string fpr Total purchase amount
		
		public Double getformattedAmount (String amount) {
			
			
			Double price=Double.parseDouble(amount.substring(1));
			return price;
			
		}		
		
		
	@AfterClass
	public void tearDown() {
	    //closing the driver
	   // driver.quit();
	    //closing the server
       service.stop();
		
		
		
	}
	
}
