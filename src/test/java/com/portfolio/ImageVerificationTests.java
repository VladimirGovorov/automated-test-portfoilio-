package com.portfolio;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.portfolio.driverFactory.DriverFactory;

import pageObjects.LandingPageImages;

public class ImageVerificationTests extends DriverFactory {
	
	LandingPageImages photos;
	
	
	@BeforeTest
	public void launchPage() throws IOException, InterruptedException {
		
		init_Driver();
		getDriver().get(prop.getProperty("AppUrl"));
		Thread.sleep(3000);
	}
	
	
	
	
	@Test
	public void verifyFirstImage() throws InterruptedException 
	{
		
		photos = new LandingPageImages(getDriver());
			
		photos.verifyImage();
		Thread.sleep(3000);
		
		
	}
	@Test
	public void checkForLogo() throws InterruptedException {
		
		photos = new LandingPageImages(getDriver());
		
		photos.verifyLogo();
		
		
		}
	@Test
	public void checkPhoneImage( ) throws InterruptedException {
		
		photos = new LandingPageImages(getDriver());
		
		photos.verifyPhoneImage();
		
		
	}
	
	
	
	
	
	}
	


