package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountpage extends BasePage{
	

		public Accountpage(WebDriver driver) {
			super(driver);
		}
		
		//locators
		
		@FindBy(xpath ="//span[normalize-space()='Account & Lists']")
		WebElement Accountpage;
		
		
		
			
		
	//actionmethods
		
		public boolean isMyAccountPageExists()   // MyAccount Page heading display status
		{
			try {
				return (Accountpage.isDisplayed());
			} catch (Exception e) {
				return (false);
			}
		}
		
		
		
		
		
}
