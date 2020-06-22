package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class listeners extends base implements ITestListener {
	base b = new base();
	ExtentTest test;
	ExtentReports	extent = ExtentReporterNG.getReportObject();
	//this methof is used to make it thread safe so that we can perform parallel execution.
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext arg0) {
		
		extent.flush();
}

	public void onStart(ITestContext arg0) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		

	}

	public void onTestFailure(ITestResult result) {
		
		// code to capture screenshot
		//test.fail(result.getThrowable()); //it is for sequential execution
		extentTest.get().fail(result.getThrowable()); //it will for parallel execution
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		// always remembered
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());

		} catch (Exception e) {

		}
		
		// it is written to get the access to the driver object for the particular tests
		//for sequential execution
		/*try {
			getScreenShotPath(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try
		{
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		
		//thread safe-only use this method for parallel execution.
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
	//	test.log(Status.PASS, "test passed"); //for sequential execution
		//for thread safe
		extentTest.get().log(Status.PASS, "test passed");//for parallel executions
		

	}

}
