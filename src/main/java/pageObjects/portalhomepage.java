package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class portalhomepage {

	
	public WebDriver driver;
	
	By SearchBox=By.name("query");
	
	public portalhomepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

public WebElement getSearchBox()
	{
		return driver.findElement(SearchBox);
	}
	
	
	
	
}
