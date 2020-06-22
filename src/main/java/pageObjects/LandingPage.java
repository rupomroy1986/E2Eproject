package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class LandingPage {

	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}



//1st way
	/*public WebElement getLogin()
	{
		return driver.findElement(signin);
	}*/
	
	//2nd way
	public WebElement getLogin()
	{
		/*//2nd method
		driver.findElement(signin).click();*/
		//1st method
		return driver.findElement(signin);
		/*LoginPage lp = new LoginPage(driver);
		return lp;*/
	}
	
	
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	//if there is more than 1 popup then use this below methods
	public int getpopupsize()
	{
		return driver.findElements(popup).size();
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
	
	
}
