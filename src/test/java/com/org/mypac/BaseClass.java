package com.org.mypac;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass 
{
	WebDriver driver;
	static ExtentReports extent;
	ExtentTest test;
	ExtentHtmlReporter htmlReporter;


	@BeforeTest
	public void t() {

		//Reporting:::::::::::::
		htmlReporter = new ExtentHtmlReporter("AdvanceProperReportExtent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("SeleniumTest");
		test.info("Starting with Automation Script!!!");
		
		//Log4j:::::::::::::::::
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
		test.info("End of Automation!!!");
		extent.flush();
	}

}
