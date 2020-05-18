package com.org.mypac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Mytest {
	WebDriver driver;
	static ExtentReports extent;
	ExtentTest test;
	ExtentHtmlReporter htmlReporter;

	@BeforeTest
	public void bt() {

		htmlReporter = new ExtentHtmlReporter("AdvanceProperReportExtent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@Parameters("testbrowser")
	@BeforeMethod
	public void t(String xyz) {

		test = extent.createTest("SeleniumTest "+xyz);
		test.info("Starting with Automation Script!!!");

		String browser = xyz;

		if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			test.info("Initilised Internet Explorer");
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver = new ChromeDriver();
			test.info("Initilised Chrome");
		} else {
			System.out.println("Browser specified is not available to run");
		}

		driver.get("https://jqueryui.com/droppable/");
		test.info("opened the site");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void af() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
		test.info("End of Automation!!!");
	}
	
	@AfterTest
	public void at(){
		extent.flush();
	}
	

	@Test
	public void x() {
		test.info("Starting with test x()");

		try {

			WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
			driver.switchTo().frame(frame1);

			WebElement first = driver.findElement(By.id("draggable"));
			first.click();

			WebElement second = driver.findElement(By.id("droppable"));
			second.click();

			Actions act = new Actions(driver);
			act.clickAndHold(first).moveToElement(second).release().build().perform();
			// act.dragAndDrop(first, second).perform();

			test.pass("x() was successful!!");

		} catch (Exception e) {
			test.fail("x() got Failed!!");
			Assert.assertTrue(false, "x() failed to execute");;
		}
	}

	@Test
	public void y() {
		test.info("Starting with test y()");
		
		try {
			Assert.assertEquals(20, 30);
			test.pass("y() was successful!!");
		} catch (AssertionError e) {
			test.fail("y() got Failed!!");
			Assert.assertTrue(false, "y() failed to execute");;
		}

	}
}
