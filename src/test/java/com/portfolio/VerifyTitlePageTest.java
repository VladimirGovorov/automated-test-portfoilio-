package com.portfolio;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.portfolio.driverFactory.DriverFactory;

import pageObjects.LandingPage;

public class VerifyTitlePageTest extends DriverFactory {
	
	public LandingPage landingPage;
	
	@BeforeTest
	public void launchBrowser() throws IOException, InterruptedException
	{
		
		init_Driver();
		getDriver().get(prop.getProperty("AppUrl"));
		Thread.sleep(4000);
	}
	
	@Test
	public void verifyTitle()
	{
		landingPage = new LandingPage(getDriver());
		landingPage.verifyPageTitle();	
	}
	
	


}
