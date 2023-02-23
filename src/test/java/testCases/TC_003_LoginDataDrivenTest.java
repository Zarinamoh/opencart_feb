package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage2;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass= DataProviders.class)
	public void test_LoginDDT(String email,String pwd ,String exp) {
		logger.info("Starting TC_003_LoginDataDrivenTest");
		try {
       HomePage hp=new HomePage(driver);
       hp.clickMyAccount();
       hp.clickLogin();
       
       LoginPage2 lp =new LoginPage2(driver);
       lp.setEmail(email);
       lp.setPassword(pwd);
       lp.clickLogin();
       
       MyAccountPage macc= new MyAccountPage(driver);
       boolean targetpg = macc.isAccountPageExists();
       
       if(exp.equals("Valid")) {
    	   if(targetpg == true) {
    		   macc.clickLogout();
    		   Assert.assertTrue(true);
    	   }
    	   else {
    		   Assert.assertTrue(false);
    	   }   
       }
       if(exp.equals("Invalid")) {
    	   if(targetpg == true) {
    		   macc.clickLogout();
    		   Assert.assertTrue(false);
    	   }
    	   else {
    		   Assert.assertTrue(true);
    	   }
          }
		}
       catch(Exception e) {
    	   Assert.fail();
       }
       
		logger.info("Finishing TC_003_LoginDataDrivenTest");    
       
     }
}
