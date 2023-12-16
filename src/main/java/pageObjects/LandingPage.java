package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.portfolio.actions.PortfolioActions;
import com.portfolio.utilities.ConfigFileReader;

public class LandingPage extends PortfolioActions{
	
	
	
	public WebDriver driver;
	
	ConfigFileReader configFileReader;
	

	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		configFileReader = new ConfigFileReader();
	}
	By aboutButton = By.cssSelector("a[class*='MuiButtonBase-root']");
	By introductionText = By.xpath("//span[@class='MuiTypography-root MuiTypography-inherit css-eiaiow']");
	By introductionText2 = By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css-gtvj52']");
	By aboutMeText = By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4 css-13in5bg']");
	public String verifyPageTitle()
	{
		
		String title =getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Vlad the QA Dev");
		return title;
	
		
	}
	
	public String verifyIntroText(String expected)
	
	{
		waitForElementToAppear(introductionText2);
		String text =readText(introductionText2, "Get: Hi my name is Vlade Text");
		System.out.println(text);
		Assert.assertEquals(text, expected);
		return text;
		
	}
	
	
	public void clickOnAbout() {
		
		click(aboutButton, "click on about");
		
	}
	
	
	public String getAboutText(String expected) {
		
		
		String text =readText(aboutButton, "get about text");
		System.out.println(text);
		Assert.assertEquals(text, expected);
		return text;
		
	
		
		
		
	}
	
	public String getWhoAmIText(String expected) {
		
		
		String text = readText(aboutMeText, "Get who am I text");
		System.out.println(text);
		Assert.assertEquals(text, expected);
		return text;
		
		
		
	}
	
	/* public String verifyIntroText() {
	        WebElement element = findElement(introductionText);

	        // Using JavascriptExecutor to get the inner text directly
	        String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element);

	        System.out.println(text);
	        return text;
	    }*/

	
	
	
}
