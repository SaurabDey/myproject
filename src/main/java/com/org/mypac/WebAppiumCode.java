package com.org.mypac;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebAppiumCode {
	WebDriver driver;
	
	@Test
	public void web_application() throws MalformedURLException, InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();*/
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("deviceName", "Lenevo");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
		
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("demo123");
		driver.findElement(By.id("wp-submit")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
