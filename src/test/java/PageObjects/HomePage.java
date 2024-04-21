package PageObjects;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver) {
		super(driver);
		
		
}
	
	
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement accountSignin;
	

	//Actionmethods
	
	       public void clickonsignin()  {
	    	  
	    	   
	    	   accountSignin.click();


	}
	
	
	
	
	
	
	
	
}

