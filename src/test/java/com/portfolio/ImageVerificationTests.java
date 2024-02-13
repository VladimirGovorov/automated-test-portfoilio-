package com.portfolio;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.portfolio.driverFactory.DriverFactory;

import pageObjects.LandingPagePhotos;

public class ImageVerificationTests extends DriverFactory {
	
	LandingPagePhotos photos;
	
	
	@BeforeTest
	public void launchPage() throws IOException, InterruptedException {
		
		init_Driver();
		getDriver().get(prop.getProperty("AppUrl"));
		Thread.sleep(3000);
	}
	
	
	
	
	@Test
	public void verifyFirstImage() 
	{
		
		photos = new LandingPagePhotos(getDriver());
			
		photos.verifyImage();
		
		
	}
	
	
	
	}
	


