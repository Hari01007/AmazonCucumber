package Stepdefinitions;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

import PageObjects.Accountpage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.DataReader;
import factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps<AccountPage> {
	WebDriver driver;
    HomePage hp;
    LoginPage lp;
    Accountpage ap;
    
    List<HashMap<String, String>> datamap; //Data driven
    

@Given("the user open the Amazon app page")
public void the_user_open_the_amazon_app_page() {
	//Baseclass.getLogger().info("Goto my account-->Click on Login.. ");
	hp=new HomePage(Baseclass.getDriver());
	

		hp.clickonsignin();
}


@When("user enters email as {string} and password as {string}")

public void user_enters_email_as_and_password_as(String email, String pwd) {
Baseclass.getLogger().info("Entering email and password.. ");
	
	lp=new LoginPage(Baseclass.getDriver());
   	lp.setEmail(email);
   	lp.clkcontinuebutton();
    lp.setPassword(pwd);
    
    }


@When("user click on Signin button")
public void user_click_on_signin_button() {
  
	lp.clkonSignin();
	Baseclass.getLogger().info("clicked on login button...");
}

@Then("user able to see the Account page")
public void user_able_to_see_the_account_page() {
  
	ap=new Accountpage(Baseclass.getDriver());
	boolean targetpage=ap.isMyAccountPageExists();
			
	Assert.assertEquals(targetpage, true);

}


//*******   Data Driven test **************
@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
{
    datamap=DataReader.data(System.getProperty("user.dir")+"\\Testdata\\Amazonusercredentials.xlsx", "Sheet1");

    int index=Integer.parseInt(rows)-1;
    String email= datamap.get(index).get("username");
    String pwd= datamap.get(index).get("password");
    String exp_res= datamap.get(index).get("res");

    lp=new LoginPage(Baseclass.getDriver());
    lp.setEmail(email);
    lp.clkcontinuebutton();
    lp.setPassword(pwd);
   
    lp.clkonSignin();
    
    
    ap=new Accountpage(Baseclass.getDriver());
    try
    {
        boolean targetpage=ap.isMyAccountPageExists();
        System.out.println("target page: "+ targetpage);
        if(exp_res.equals("Valid"))
        {
            if(targetpage==true)
            {
            	Accountpage myaccpage=new Accountpage(Baseclass.getDriver());
              myaccpage.isMyAccountPageExists();
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }

        if(exp_res.equals("Invalid"))
        {
            if(targetpage==true)
            {
                //ap.clickLogout();
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }


    }
    catch(Exception e)
    {

        Assert.assertTrue(false);
    }
  }

}


