package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;

public class TC_002LoginTest extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void testLogin() {
		try {
		logger.info("********Starting TC_002LoginTest *********");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing login details");
		lp.setEmail(properties.getProperty("email"));
		lp.setPassword(properties.getProperty("password"));
		lp.clickLogin();
		MyAccountPage macc=new MyAccountPage(driver);
		boolean confirmmsg = macc.isMyAccountExists();
		Assert.assertTrue(confirmmsg);//Assert.assertEquals(confirmmsg, true);
		logger.info("********Ending TC_002LoginTest *********");
		}catch(Exception e) {
			Assert.fail();
		}
	}

}
