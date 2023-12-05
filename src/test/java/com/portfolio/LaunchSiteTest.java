package com.portfolio;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.testng.annotations.BeforeTest;

import com.portfolio.driverFactory.DriverFactory;
//import org.testng.annotaions.Test;
public class LaunchSiteTest extends DriverFactory {
	
	
	@Test
	public void launchSite() throws IOException, InterruptedException
	{
		init_Driver();
		getDriver().get(prop.getProperty("AppUrl"));
		Thread.sleep(3000);
	}
	
	

}
