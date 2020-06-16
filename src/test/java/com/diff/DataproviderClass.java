package com.diff;

import org.testng.annotations.DataProvider;

public class DataproviderClass {
	@DataProvider(name="myDP")
	public Object[][] datap()
	{
		return new Object[][] {{"chrome"},{"ie"},{"firefox"}};
		
	}
}
