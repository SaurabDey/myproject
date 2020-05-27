package com.org.mypac;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
	static Logger log= Logger.getLogger(LoginClass.class);
	
	@FindBy(id= "txtUsername")
	WebElement locatorusername;
	
	@FindBy(name= "txtPassword")
	WebElement locatorpass;
	
	@FindBy(id= "btnLogin")
	WebElement locatorLoginbutn;
	
	WebDriver driver ;
	public LoginClass(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void log()
	{
		
		Map<Integer, List<String>> getExcelData=CommonUtill.excelRead();
		
		locatorusername.sendKeys(getExcelData.get(1).get(0));//first Admin

		locatorpass.sendKeys(getExcelData.get(1).get(1));//first admin123
		
		locatorLoginbutn.click();
		
		log.info("Logged in with >>>> :"+getExcelData.get(1).get(0));
		
	}

}
