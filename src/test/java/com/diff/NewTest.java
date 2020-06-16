package com.diff;

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
	  System.out.println(100/0);
  }
  
  @Test
  public void z() {
	  
	  System.out.println(">>>>my test z()");
  }
  
  @Test
  public void a() {
	  
	  System.out.println(">>>>my test a()");
  }

}
