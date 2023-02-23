package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
		
		@Test(groups= {"Sanity","Master"})
		public void test_account_registration() throws InterruptedException{
			
			logger.debug("application logs......");
			logger.info("***  Starting TC_001_AccountRegistrationTest ***");
			
			try {
				HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
				hp.clickRegister();
				logger.info("Clicked on register link");
				
				AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
				logger.info("Providing customer data");
				regPage.setFirstName(randomString().toUpperCase());
				regPage.setLasttName(randomString().toUpperCase());
				regPage.setEmail(randomString()+"@gmail.com");
				
				String password = randomAlphaNumeric();
				regPage.setPassword(password);
				regPage.checkPolicy();
				regPage.clickContinue();
				logger.info("Clicked on continue");
				
				String confirmMsg=regPage.getConfirmationMessage();
				logger.info("Validating expected message");
				Assert.assertEquals(confirmMsg, "Your Account Has Been Created!","Test failed");
			}
			
			catch(Exception e) {
				Assert.fail();
			}
		}
		
	}

