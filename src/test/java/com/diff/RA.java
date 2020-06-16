package com.diff;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RA implements IRetryAnalyzer{

	int max=0;
	@Override
	public boolean retry(ITestResult result) {

		if (max<3) {
			if (!result.isSuccess()) 
			{
				max++;
				return true;
			}
		}
		
		return false;
	}

}
