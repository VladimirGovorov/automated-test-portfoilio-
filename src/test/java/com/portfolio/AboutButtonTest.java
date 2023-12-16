package com.portfolio;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.portfolio.driverFactory.DriverFactory;

import pageObjects.LandingPage;

public class AboutButtonTest extends DriverFactory {
	
	public LandingPage landingPage;
	
	
	@BeforeTest
	public void launchSite() throws IOException, InterruptedException
	{
		init_Driver();
		getDriver().get(prop.getProperty("AppUrl"));
		Thread.sleep(3000);
	}

	
	
	
	@Test
	public void verifyAboutButton() throws InterruptedException {
		
		landingPage = new LandingPage(getDriver());
		Thread.sleep(3000);
		landingPage.getAboutText("ABOUT");
		Thread.sleep(3000);
		landingPage.clickOnAbout();
		Thread.sleep(3000);
		landingPage.getWhoAmIText("Who am I?"); 

		
		
		
		
	}
}
