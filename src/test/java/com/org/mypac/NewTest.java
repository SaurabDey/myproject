package com.org.mypac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class NewTest {
  @Test
  public void f() {
	  
	  System.out.println(">>>>my test f()");
  }
  
  @Test
  public void z() {
	  
	  System.out.println(">>>>my test z()");
  }
  
  @BeforeMethod
  public void beforem() {
	  System.out.println(">>>>my before method");
  }

  @AfterMethod
  public void afterm() {
	  System.out.println(">>>>my after method");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println(">my before test");
  }

  @AfterTest
  public void aftertest() {
	  System.out.println(">my after test");
  }
  
  @BeforeClass
  public void beforec() {
	  System.out.println(">>>my before class");
  }

  @AfterClass
  public void afterc() {
	  System.out.println(">>>my after class");
  }
  
  @BeforeSuite
  public void beforeS() {
	  System.out.println("my before suite");
  }

  @AfterSuite
  public void afterS() {
	  System.out.println("my after suite");
  }

}
