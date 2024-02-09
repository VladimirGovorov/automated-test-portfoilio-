package com.portfolio;

import org.testng.annotations.Test;
import java.io.IOException;
//import org.junit.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.portfolio.driverFactory.DriverFactory;

import pageObjects.LandingPage;

public class VerifyIntroductionTest extends DriverFactory {
	
	public LandingPage landingPage;

	@BeforeTest
	public void launchSite2() throws IOException, InterruptedException
	{
		init_Driver();
		getDriver().get(prop.getProperty("AppUrl"));
		Thread.sleep(3000);
	}
	
	@Test
	public void getIntroText()
	{
		landingPage = new LandingPage(getDriver());
		landingPage.verifyIntroText("Hi there! 👋I'm Vlad"); 
		
	}
	
	
	
	
	
	
	
}
