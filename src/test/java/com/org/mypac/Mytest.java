package com.org.mypac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Mytest 
{
	WebDriver driver;
	
	@Parameters("testbrowser")
	@BeforeTest
	public void t(String xyz)
	{
		String browser= xyz;
		
		if (browser.equals("ie")) 
		{
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		} 
		else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
           System.out.println("Browser specified is not available to run");
		}

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void af() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
	@Test
	public void x()
	{
		WebElement frame1=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame1);
		
		WebElement first=driver.findElement(By.id("draggable"));
		first.click();
		
		WebElement second=driver.findElement(By.id("droppable"));
		second.click();

		Actions act= new Actions(driver);
		act.clickAndHold(first).moveToElement(second).release().build().perform();
		//act.dragAndDrop(first, second).perform();
	}

	@Test
	public void y()
	{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	}
}
