package testPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass2 {
	@Parameters({"browserName"})


	@BeforeTest
	public void beforeTest(String browserName)
	{
		if(browserName.equals("chrome"))
		{
		System.err.println("Opening the chrome browser");
		}
		else if (browserName.equals("firefox"))
		{
			System.err.println("Opening the firefox browser");
		}
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("beforeClass of Class2");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("beforeMethod of Class2");
	}
	@Test
	
	public void test1() throws InterruptedException
	{
		System.out.println("test1 of class2");
		//Thread.sleep(2000);
	}
	
	@Test
	public void test2()
	{
		System.out.println("test2 of class2");
	}

	//@AfterMethod
	//public void afterMethod()
	//{
		//System.out.println("afterMethod of class2");
	//}
	@AfterClass
	public void afterClass()
	{
		System.out.println("afterClass of class2");
	}
	
	@AfterTest
	public void afterTest()
	{
		//System.err.println("aftertest of Class2");
	}
	 @AfterSuite
	 public void afterSuite()
	 {
		 System.out.println("afterSuite of Class2");
	 }
	
}
