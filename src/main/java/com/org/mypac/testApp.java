package com.org.mypac;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class testApp {

	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		
		WebElement email= driver.findElement(By.id("txtUsername"));
		email.sendKeys("Admin");
		WebElement pass= driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");
		WebElement login= driver.findElement(By.id("btnLogin"));

		File src=email.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("Resource/screen.png"));
		driver.quit();

	}

}
