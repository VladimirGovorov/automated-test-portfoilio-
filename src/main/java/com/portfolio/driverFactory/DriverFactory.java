package com.portfolio.driverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory { 
	
	public WebDriver driver;
	
	public Properties prop;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_Driver() throws IOException
	{
		
	    prop = new Properties();
		String filePath = System.getProperty("user.dir")+"/configurations/config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		
        System.out.println("browser value is:" +browser);
		
		if(browser.equals("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge"))
		{
			//WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else if(browser.equals("opera"))
		{
			//WebDriverManager.operadriver().setup();
			//tlDriver.set(new WebDriver());
		}
		else
		{
			System.out.println("Please pass the correct browset vlaue: "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
			
	}
	
	
	public WebDriver init_Driver(String browser) throws IOException
	{
		
	    prop = new Properties();
		String filePath = System.getProperty("user.dir")+"/confgurations/config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		
		//String browser = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		
        System.out.println("browser value is:" +browser);
		
		if(browser.equals("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge"))
		{
			//WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else if(browser.equals("opera"))
		{
			//WebDriverManager.operadriver().setup();
			//tlDriver.set(new WebDriver());
		}
		else
		{
			System.out.println("Please pass the correct browset vlaue: "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
			
	}
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	

}
