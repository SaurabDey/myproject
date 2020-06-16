package com.org.mypac;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoITScript {
	WebDriver driver;

	@Test
	public void t() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://demosite.center/wordpress/wp-login.php");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("demo123");
		driver.findElement(By.id("wp-submit")).click();
		WebElement clickPost=  driver.findElement(By.xpath("//div[text()='Posts']"));
        clickPost.click();
        WebElement clickAddnew=  driver.findElement(By.xpath("//a[text()='Add New'][@href='post-new.php']"));
        clickAddnew.click();
		
        WebElement clickSetimage=  driver.findElement(By.xpath("//button[text()='Set Image']"));
        clickSetimage.click();
		driver.findElement(By.xpath("//a[text()='Upload Files']")).click();;
		driver.findElement(By.xpath("//button[text()='Select Files']")).click();
		
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("Resource/UploadScript.exe");
		
		Thread.sleep(10000);
		driver.quit();
	}

}
