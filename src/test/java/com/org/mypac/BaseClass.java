package com.org.mypac;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass 
{
	WebDriver driver;

	@BeforeTest
	public void t() {

		//BasicConfigurator.configure();
		PropertyConfigurator.configure("Resource/log4j.properties");
		
		System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void af() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();

	}

}
