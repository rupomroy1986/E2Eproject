package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized for the home page");

	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String Username, String Password, String text) throws IOException {

		// one is inheritance

		// creating object to that class and invoke methods of it. Here we are writing
		// the properties file because one time it is
		// taking the url for multiple sets of data
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		// 1st way
		
		 l.getLogin().click(); // driver.findElement(By.css() 
		  LoginPage lp = new LoginPage(driver);
		 

		// 2nd way
		/*LoginPage lp = l.getLogin();*/

		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		log.info(text);

		lp.getLogin().click();
		//here, I am making the test as comment out as it is landing to some other page through automation script.
		/*ForgotPassword fp = lp.forgotpassword();
		fp.getEmail().sendKeys("xxxx");
		fp.sendMeInstructions().click();
*/
	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// coloumn stands for how many values per each test

		// Array size is 2
		// 0,1
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restrcited User";
		// 1st row

		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non restricted user";

		return data;

	}

}
