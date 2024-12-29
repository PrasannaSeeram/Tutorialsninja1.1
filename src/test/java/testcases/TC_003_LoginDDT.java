package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verifyLoginDDT(String email,String pwd,String exprst) {
		try {
		logger.info("********Starting TC_002LoginTest *********");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing login details");
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		MyAccountPage macc=new MyAccountPage(driver);
		boolean confirmmsg = macc.isMyAccountExists();
	if(exprst.equalsIgnoreCase("valid")) {           //valid------>login-passed
		if(confirmmsg==true) {                          //         not login-failed
		macc.clickLogout();
		Assert.assertTrue(true);                    //invalid------> login-failed
		}else {                                      //             not login-passed
			Assert.assertTrue(false);
		}
	}else {
		if(confirmmsg==true) {
			macc.clickLogout();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}
			
		}
	
	logger.info("******Finishing TC_002LoginTest *********");
		}catch(Exception e) {
			Assert.fail();
		}
	}

}
