package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage2;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	

	@Test(groups= {"Regression","Master"})
	public void test_Login() {
		logger.info("Starting TC_002_LoginTest");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			logger.info("Sending Email and Password");
			LoginPage2 lp =new LoginPage2(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			lp.clickLogin();
			
			logger.info("Click login button");
			MyAccountPage accp = new MyAccountPage(driver);
			boolean targetPage = accp.isAccountPageExists();
			Assert.assertEquals(targetPage,true);	
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC_002_LoginTest");
	}
}
	


