package com.portfolio;

import java.io.IOException;

import org.junit.Test;

import com.portfolio.driverFactory.DriverFactory;

public class JunitTest extends DriverFactory {
	
	
	
	
	@Test
   public void launchPortfolio() throws IOException, InterruptedException
   {
	   init_Driver();
	   getDriver().get(prop.getProperty("AppUrl"));
	   Thread.sleep(3000);
	   
   }

}
