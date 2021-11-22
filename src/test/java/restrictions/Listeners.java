package restrictions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporter;

public class Listeners extends Base implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporter.getReportObject();
	
	//To make the framework thread safe.
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		tl.set(test);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS, "Test Case Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		tl.get().fail(result.getThrowable());
		
		// Thread safe method
	    WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			 
		} catch (Exception e){
			e.printStackTrace();
		}
		
	  
		try {
			
			 String imagePath= getScreenShot(testMethodName, driver);
			
			tl.get().addScreenCaptureFromPath(imagePath, result.getMethod().getMethodName());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
	
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
		
	}

}
