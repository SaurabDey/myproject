package com.org.mypac;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class POMClass extends BaseClass

{
	static Logger log= Logger.getLogger(POMClass.class);
	
	@Test(priority=1)
	public void login() {
		log.info("executing login test");
		LoginClass l= new LoginClass(driver);
		l.log();	
		log.info("Sucessfully executed login test");
	}
	
	@Test(priority=2)
	public void adduser() {
		log.info("executing adduser test");
		SaveSystemUserClass s= new SaveSystemUserClass(driver);
		s.add();
		log.info("Sucessfully executed adduser test");
	}
}
