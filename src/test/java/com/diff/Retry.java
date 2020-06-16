package com.diff;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count = 0;

	@Override
	public boolean retry(ITestResult result) {

		if (count < 2) {

			if (!result.isSuccess()) {
				count++;
				return true;
			}

		}
		return false;
	}

}
