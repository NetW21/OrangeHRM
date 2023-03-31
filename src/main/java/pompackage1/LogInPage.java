package pompackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pomUtility.ElementWait;

public class LogInPage {

	WebDriver driver;
	
	
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userName;
		
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
		
	@FindBy(xpath="//button[text()=' Login ']")	
	private WebElement liginButton;
		
		
	public LogInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
		
	public void SendUN(String uname)
	{
		//ElementWait.waitForElement("//input[@name='username']", 20, driver);
	
		userName.sendKeys(uname);
	}

	public void sendpass( String sendpass)
	{
		password.sendKeys(sendpass);
	}
	public void clickonlogin()
	{
		liginButton.click();
	}


//	public boolean compareUrl()
//	{
//	 String ExpectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
//	 String CurrentUrl=driver.getCurrentUrl();
//	 boolean res=ExpectedUrl.equals(CurrentUrl);
//	 return res;
//	}
//
//
//	public boolean displayedLogin()
//	{
//		boolean result=liginButton.isDisplayed();
//		return result;
//	}
}
