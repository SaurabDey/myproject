package com.diff;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNgClass {
	

	@Test
	  public void f() {
		  
		  System.out.println(">>>>my test f()");

	  }
	  
	  @Test
	  public void z() {
		  
		  System.out.println(">>>>my test z()");
		  Assert.assertEquals(30, 40);
	  }
	  
	  @Test
	  public void a() {
		  
		  System.out.println(">>>>my test a()");
	  }

}
