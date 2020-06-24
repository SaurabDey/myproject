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

public class AppiumWebApp {

	WebDriver driver;
	@Test
	public void web_application() throws InterruptedException, MalformedURLException
	{
	
		/*System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();*/
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Lenovo");
		capabilities.setCapability("browserName", "chrome");
		
		driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.get("https://www.facebook.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("m_login_email")).sendKeys("admin");
		driver.findElement(By.id("m_login_password")).sendKeys("demo123");
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
