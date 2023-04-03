package testPackage;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pompackage1.Dashboard_OrangeHRM;
import pompackage1.LogInPage;
import testUtility.ReadFileData;

public class TestClass extends BaseClass {
	//WebDriver driver;	
	LogInPage logp;
	Dashboard_OrangeHRM admin;
	ReadFileData r;
	
@BeforeClass
public void beforeClass()
{
	
	logp = new LogInPage(driver);
	System.out.println("Beforeclass");
	
//	System.setProperty("WebDriver.chrome.driver","src\\test\\resources\\Driver\\chromedriver.exe");
//	 driver=new ChromeDriver();
//	  logp=new LogInPage(driver);
//	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	  admin =  new Dashboard_OrangeHRM(driver);
//	 driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
}
	
@BeforeMethod
public void beforeMethod()
{
	System.out.println("Beforemethod");
}
@Test(priority=1)
public void test1() throws EncryptedDocumentException, IOException, InterruptedException
{
	logger = report.createTest("Verify login functionality with correct data");
	SoftAssert s=new SoftAssert();
	logp.SendUN(r.fetchDataFromExcel(1, 0));	
	logp.sendpass(r.fetchDataFromExcel(1, 1));
	logp.clickonlogin();
	Thread.sleep(3000);
	WebElement el = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[5]"));
	File source = el.getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Users\\Mahesh Waghmode\\eclipse-workspace\\HRMOrange\\test-output\\Screenshots\\temp.png");
	FileHandler.copy(source, dest);
	s.assertAll();
	logger.pass("Test Case is pass");
	
	/*String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String CurrentUrl="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNum";
	s.assertEquals(CurrentUrl,ExpectedURL);		
	*/
	//boolean re1=logp.displayedLogin(); not working
	//Assert.assertTrue(re1); // not working 
	//Assert.assertTru
	}
@Test(priority=2, timeOut= 20000)
public void VerifyAdminTab()
{

admin.VerifyAdminTab();
admin.verifyusername();
admin.veifyuserrole();
Assert.fail();
System.out.println("Test Case Execution");
}

//@AfterMethod
//public void afterMethod()
//{
//	
//}

@AfterClass()
public void afterClass() {
	
	System.out.println("Afterclass");
	
	//driver.quit();
	
}
}