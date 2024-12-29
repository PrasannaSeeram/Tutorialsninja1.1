package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegisterPage;
import testbase.BaseClass;

public class TC_001RegisterAccountTest extends BaseClass{


	@Test(groups={"Sanity","Master"})
	public void testRegister() {
		try {
		logger.info("**** Starting TC_001VerifyAccountRegister ****");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicking on MyAccount");
		hp.clickRegister();
		logger.info("Clicking on Register");
		RegisterPage rp=new RegisterPage(driver);
		logger.info("Providing Registering Details");
		rp.setFirstname(randomString().toUpperCase());
		rp.setLastname(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com");
		String password = randomNumber();
		rp.setPassword(password);
		rp.setPasswordConfirm(password);
		rp.setTelephone(randomNumber());
		rp.checkPrivacypolicy();
		rp.clickContinue();
		logger.info("validation starting");
		boolean conf = rp.getConfirmationMsg();
		Assert.assertEquals(conf, true);
		}catch(Exception e) {
			logger.error("test failed");
			logger.debug("debug details");
			Assert.fail();
		}
	}
	
	
	
}
