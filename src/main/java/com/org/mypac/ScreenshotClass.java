package com.org.mypac;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ScreenshotClass {

	WebDriver driver;

	@Test
	public void t() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://demosite.center/wordpress/wp-login.php");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		WebElement user=driver.findElement(By.id("user_login"));
		user.sendKeys("admin");
		CommonUtill.elementScreenshots(user, "userTextField");
		
		
		WebElement pass=driver.findElement(By.id("user_pass"));
		pass.sendKeys("demo123");
		CommonUtill.elementScreenshots(pass, "passTextField");
		
		WebElement loginButn= driver.findElement(By.id("wp-submit"));
		
		
		WebElement form=driver.findElement(By.id("loginform"));
		//Specific element's screenshot
		CommonUtill.elementScreenshots(form, "entierForm");
		
		loginButn.click();
		
		WebElement clickPost=  driver.findElement(By.xpath("//div[text()='Posts']"));
        clickPost.click();
        
        
        //Full Screenshot
        CommonUtill.captureScreenShot(driver, "WordPressScreenshot");
	}
	
	@AfterTest
	public void af() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
	
}
