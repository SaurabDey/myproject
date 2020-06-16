package com.win;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class WiniumClassDesktop {

	public static void main(String[] args) throws MalformedURLException {		
		/*DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("", "");
		RemoteWebDriver driver =new RemoteWebDriver(new URL(""), cap);*/
		
		DesktopOptions options=new DesktopOptions();
		options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		
		WiniumDriver win=new WiniumDriver(new URL("http://localhost:9999"), options);	
		System.out.println("Application launched");
		
		win.findElement(By.id("137")).click();
		win.findElement(By.name("Add")).click();
		win.findElement(By.id("135")).click();
		win.findElement(By.name("Equals")).click();	
		//To do get text
		System.out.println(win.findElement(By.id("150")).getAttribute("Name"));
	}

}
