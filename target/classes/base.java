package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
prop= new Properties();
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
prop.load(fis);
String browserName=prop.getProperty("browser");
//if you want to run the project with maven then use the following details

//String browserName=System.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 //System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Cucumber Latest\\\\\\\\83\\\\\\\\chromedriver.exe");
	//here we have set up the dynamic path.
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", "C:\\Framework execution selenium\\chromedriver.exe");

	 ChromeOptions a1=new ChromeOptions();
	 if(browserName.contains("headless"))
	 {
		 a1.addArguments("headless");
	 }
	 driver= new ChromeDriver(a1);	 
	 //driver= new ChromeDriver(a1);
	 
}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}

public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
	


}


}
