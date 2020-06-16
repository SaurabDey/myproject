package com.diff;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dp 

{
	
	@BeforeMethod
	public void bx()
	{
	System.out.println("BM");
	}
	
	/*@DataProvider(name="myDP")
	public Object[][] datap()
	{
		return new Object[][] 
			{
			{"Kirti", 101, true},
			{"Vikas", 202, false},
			{"Amar", 303, true},
			{"Datta", 404, false}
			};
		
	}
	

	@Test(dataProvider="myDP")
	public void x(String name, int rollnumber, boolean val)
	{
    System.out.println("The values from Dataprovider is : " +name);
    System.out.println("The Rool number from Dataprovider is : " +rollnumber);
    System.out.println("The bolean value from Dataprovider is : " +val);
	}*/

	
	WebDriver driver;
	@Test(dataProviderClass=DataproviderClass.class, dataProvider="myDP")
	public void x(String xyz)
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
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
           System.out.println("Browser specified is not available to run");
		}

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void af() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
}
