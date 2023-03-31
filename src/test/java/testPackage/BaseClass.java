package testPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testUtility.Screenshot;
import testUtility.StaticBrowser;

public class BaseClass {
	static WebDriver driver;
	public static ExtentReports report;
	 public static ExtentHtmlReporter extent;
	 public static ExtentTest logger;
	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browser)
	{
		report = new ExtentReports();
		extent = new ExtentHtmlReporter("C:\\Users\\Mahesh Waghmode\\eclipse-workspace\\HRMOrange\\test-output"+File.separator+"Reports"+File.separator+"Hrmthread"+System.currentTimeMillis()+".html");
	   WebDriver driver  = StaticBrowser.openBrowser(browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		report.attachReporter(extent);
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
	
	}
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			 String path=Screenshot.capturePageScreenshot(driver);
			logger.fail("Test case is fail",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		report.flush();
		logger.pass("Test case is pass");
	}
	@AfterTest
	public void afterTest() 
	
	{
		//driver.quit();
	}

}
