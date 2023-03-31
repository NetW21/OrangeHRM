package pompackage1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_OrangeHRM {

	
	//Step 1
	//WebDriver driver;
	
	
	
	@FindBy(xpath="//a[@class='oxd-main-menu-item'][1]")
     private WebElement Admin;
	
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement Username ;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'][1]")
	private WebElement userrole;
	
    
	//Step 2
	public Dashboard_OrangeHRM (WebDriver driver)
    {
    	//this.driver=driver;
    	PageFactory.initElements(driver, this);

    }
	
	//Step 2
	 public void VerifyAdminTab()
	 {
		 Admin.click();
		
	 }
	 
	 public void verifyusername()
	 {
		 Username.sendKeys("admin");
		 
	 }
	 
	 public void veifyuserrole()
	 {
		 
		 userrole.isSelected();
		 
		 System.out.println("Yes");
	 }
    
}
