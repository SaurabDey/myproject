package com.org.mypac;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AppiumNativeApp {

	WebDriver driver;
	@Test
	public void web_application() throws InterruptedException, MalformedURLException
	{
	
		/*System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();*/
		File nativeApp= new File("Resource/TheMallApp.apk");
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("app", nativeApp.getAbsolutePath());
		
		driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		Thread.sleep(10000);
		
		WebElement nameButton=driver.findElement(By.xpath("//android.widget.Button[@text='Jerry Brown (Newbie)']"));
		nameButton.click();
		Thread.sleep(10000);
		
		WebElement offer=driver.findElement(By.xpath("//android.widget.TextView[@text='OFFERS']"));
		offer.click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
