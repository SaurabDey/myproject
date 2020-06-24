package com.org.mypac;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AppiumNativeAdvance {
	AndroidDriver<WebElement> driver;
	@BeforeTest
	public void b() throws MalformedURLException
	{
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		File mall= new File("Resource/CoCoin.apk");
		//capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability("app",mall.getAbsolutePath());
		capabilities.setCapability("deviceName", "lenovo");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
		
		driver= new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void t() throws InterruptedException
	{

		for (int i = 0; i < 4; i++) {
			swipeRight();
		}
		
//		Thread.sleep(5000);
//		for (int i = 0; i < 4; i++) {
//			WebElement pin1=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.nightonke.cocoin:id/frame_layout']"));
//			pin1.click();
//		}
//		
		
		Thread.sleep(5000);
		for (int i = 0; i < 4; i++) {
			WebElement pin1=driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.nightonke.cocoin:id/frame_layout']"));
			pin1.click();
		}
		
	}
	

	public void swipeRight() throws InterruptedException
	{
		Thread.sleep(5000);
		//TouchAction<TouchAction<press>> act=new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * 0.7);
		int startPoint = (int) (size.width * 0.7);
		int endPoint = (int) (size.width * 0.01);
		// new TouchAction(driver).press(startPoint, anchor).waitAction(duration).moveTo(endPoint, anchor).release().perform();
		new TouchAction(driver).press(startPoint,anchor).waitAction(Duration.ofSeconds(3)).moveTo(endPoint,anchor).release().perform();

	}
	
	@AfterTest
	public void af()
	{
		driver.quit();
	}
}
