package PageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	

	
	@FindBy(xpath ="//input[@id='ap_email']")
	WebElement enterEmailAddress;
	

	
	@FindBy(xpath ="//input[@id='continue']")
	WebElement clickcontinue;
	
	
	@FindBy(xpath ="//input[@id='ap_password']")
	WebElement enterpassword;
	
	
	@FindBy(xpath ="//input[@id='signInSubmit']")
	WebElement Signin;
	
	

	//Actionmethods
	
	
	public void setEmail(String email) {
		enterEmailAddress.sendKeys(email);
	}

	
	public void clkcontinuebutton() {
		clickcontinue.click();
	}
	public void setPassword(String pwd) {
		enterpassword.sendKeys(pwd);
	}

	public void clkonSignin() {
		
		Signin.click();
	
	}
	
}

