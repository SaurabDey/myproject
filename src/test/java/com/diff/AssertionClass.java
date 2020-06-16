package com.diff;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionClass {
	WebDriver driver;

	@Test
	public void z() {

		System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/user");
		//SoftAssert soft= new SoftAssert();
		//soft.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/user");
		
		System.out.println("Sentence after Assertion : Pass");
		//soft.assertEquals(30, 40);
		
		Assert.assertEquals(30, 40);
		//soft.assertAll();

	}
	
	@AfterTest
	public void af()
	{
		driver.quit();
	}

}
