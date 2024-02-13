package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.portfolio.actions.PortfolioActions;
import com.portfolio.utilities.ConfigFileReader;

public class LandingPagePhotos extends PortfolioActions {
	
	public WebDriver driver;
	ConfigFileReader configFileReader;
	
	
	public LandingPagePhotos(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		
		
		
		configFileReader = new ConfigFileReader();
	}
	
	
	By firstPicture = By.xpath("//img[@class='Home_heroImage__TUNRx']");
	
	
	
	
	public Boolean verifyImage() {
		
	Boolean condition = driver.findElement(By.xpath("//img[@class='Home_heroImage__TUNRx']"))
	.isDisplayed();
	
	
	System.out.println(condition);
	
	//Thread.sleep(4000);
	
	Assert.assertTrue(condition.equals(true));
	
	return condition;
		
	}
	
	


}
