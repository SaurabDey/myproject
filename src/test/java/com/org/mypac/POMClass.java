package com.org.mypac;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

public class POMClass extends BaseClass

{
	static Logger log = Logger.getLogger(POMClass.class);

	@Test(priority = 1)
	public void login() throws IOException {
		try {
			log.info("::::::executing login test");
			LoginClass l = new LoginClass(driver);
			l.log();
			log.info("::::::Sucessfully executed login test");
			test.pass("login() was successful!!");
		} catch (Exception e) {
			test.fail("login() got Failed!! " + e, MediaEntityBuilder
					.createScreenCaptureFromPath(CommonUtill.captureScreenShot(driver, "Login Failure")).build());
			Assert.assertTrue(false, "login() failed to execute");
		}
	}

	@Test(priority = 2)
	public void adduser() throws IOException {
		try {
			log.info(":::::executing adduser test");
			SaveSystemUserClass s = new SaveSystemUserClass(driver);
			s.add();
			log.info(":::::Sucessfully executed adduser test");
			test.pass("adduser()  was successful!!");
		} catch (Exception e) {
			test.fail("adduser() got Failed!! " + e, MediaEntityBuilder
					.createScreenCaptureFromPath(CommonUtill.captureScreenShot(driver, "AddUser Failure")).build());

			Assert.assertTrue(false, "adduser() failed to execute");
		}
	}
}
