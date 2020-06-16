package com.org.mypac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class JSClass {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		/*driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();;*/
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('txtUsername').value='Admin';");
		
		js.executeScript("document.getElementById('txtPassword').value='admin123';");
		
		js.executeScript("document.getElementById('btnLogin').click();");
		
		Thread.sleep(10000);
		
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(10000);
		driver.quit();
	}

}
