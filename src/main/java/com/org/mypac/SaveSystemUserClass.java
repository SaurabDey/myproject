package com.org.mypac;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveSystemUserClass {
	
	static Logger log= Logger.getLogger(SaveSystemUserClass.class);
	
	@FindBy(id= "btnAdd")
	WebElement locatoraddbutn;
	
	@FindBy(id= "systemUser_employeeName_empName")
	WebElement locatorUser;
	
	@FindBy(id= "systemUser_userName")
	WebElement locatorusername;
	
	@FindBy(id= "systemUser_password")
	WebElement locatorpassword;
	
	@FindBy(id= "systemUser_confirmPassword")
	WebElement locatorconfirmpassword;
	
	@FindBy(id= "btnCancel")
	WebElement locatorCancel;
	
	WebDriver driver;
	public SaveSystemUserClass(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void add()
	{
		log.info("Executing Adding users method");
		Map<Integer, List<String>> getExcelData=CommonUtill.excelRead();
		//1 , Admin	admin123	John Smith	John 	Test123	Test123
        //2 , Admin	admin123	Linda Anderson	Linda	Test123	Test123
        //3 , Admin	admin123	Russel Hamilton	Russel	Test123	Test123
		
		for (int i = 1; i <= getExcelData.size(); i++) {
			locatoraddbutn.click();

			locatorUser.sendKeys(getExcelData.get(i).get(2));;
			log.info("Adding user : "+getExcelData.get(i).get(2));
			
			locatorusername.sendKeys(getExcelData.get(i).get(3));
			
			locatorpassword.sendKeys(getExcelData.get(i).get(4));
			
			locatorconfirmpassword.sendKeys(getExcelData.get(i).get(5));
			
			locatorCancel.click();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Adding user from database:::::::::::");
		//database integration with selenium
		List<String> dataFromDatabase =CommonUtill.databaseData();
		
		locatoraddbutn.click();

		locatorUser.sendKeys(dataFromDatabase.get(0));//Julie
		locatorusername.sendKeys(dataFromDatabase.get(1));//Murphy
		
		locatorpassword.sendKeys("test@123");
		locatorconfirmpassword.sendKeys("test@123");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
