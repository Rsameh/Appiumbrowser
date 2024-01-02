package testapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@BeforeTest
	public void TheSetUp() {

		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "QA");

	
		caps.setCapability("chromedriverExecutable", "D:\\chrome\\chromedriver.exe");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

	}

	@Test()
	public void TestTheBrowser() throws MalformedURLException, InterruptedException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> myitems = driver.findElements(By.className("btn_primary"));
		for (int i=0; i<myitems.size(); i++ ) {
			myitems.get(i).click();
		}
		
		
	}

	
	@AfterTest
	public void posttesting() {
}
}
