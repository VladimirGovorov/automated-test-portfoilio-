package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.portfolio.actions.PortfolioActions;
import com.portfolio.utilities.ConfigFileReader;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class LandingPageImages extends PortfolioActions {
	
	public WebDriver driver;
	ConfigFileReader configFileReader;
	
	
	public LandingPageImages(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		
		
		
		configFileReader = new ConfigFileReader();
	}
	
By logo = By.xpath("(//img[@alt='logo'])[1]");
By firstPicture = By.xpath("//img[@class='Home_heroImage__TUNRx']");
By phoneImage= By.xpath("(//img[@alt='Avatar image'])[3]");
By contactButton= By.cssSelector("a[class*='MuiButtonBase-root MuiButton-root MuiButton-outlined']");
	
	
	
	
	public Boolean verifyImage() {
		
	Boolean condition = driver.findElement(firstPicture)
	.isDisplayed();
	
	
	System.out.println(condition);
	
	//Thread.sleep(4000);
	
	Assert.assertTrue(condition.equals(true));
	
	return condition;
		
	}
	
	public Boolean verifyLogo() throws InterruptedException {
		
	Boolean logoCondition =driver.findElement(logo).isDisplayed();
	System.out.println(logoCondition);
	Thread.sleep(3000);
	Assert.assertTrue(logoCondition.equals(true));
	return logoCondition;
	
	
		
		
	}
	
	public Boolean verifyPhoneImage() throws InterruptedException {
		
		click(contactButton, "click on the contact button");
		Thread.sleep(3000);
		Boolean phoneCondition = driver.findElement(phoneImage).isDisplayed();
		System.out.println(phoneCondition);
		Assert.assertTrue(phoneCondition.equals(true));
		return phoneCondition;
		
		
		
	}
	
	


}
