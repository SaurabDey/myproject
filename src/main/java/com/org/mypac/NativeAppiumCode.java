package com.org.mypac;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class NativeAppiumCode {
	WebDriver driver;
	
	@Test
	public void web_application() throws MalformedURLException, InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();*/
		File nativeApplication= new File("Resource/CoCoin.apk");
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("app",nativeApplication.getAbsolutePath());
		capabilities.setCapability("deviceName", "Lenevo");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
		
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
