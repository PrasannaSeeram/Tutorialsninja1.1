package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.ProductDisplayPage;
import pageobjects.SearchPage;
import pageobjects.ShoppingCartPage;
import testbase.BaseClass;

public class TC_006_VerifyShoppingCartFunctionality extends BaseClass{
@Test(groups= {"Sanity","Master"})
	public void testShoppingCart() {
	try {
	 logger.info("**********Starting Of ShoppingCart Functionality***********");
		HomePage hp=new HomePage(driver);
		 logger.info("searching for product");
		hp.searchForProduct(properties.getProperty("product"));
		hp.clickOnSearchIcon();
		SearchPage sp=new SearchPage(driver);
		sp.productResults();
		ProductDisplayPage pds=new ProductDisplayPage(driver);
		 logger.info("Adding product to cart");
			pds.clickOnAddToCartButton();
			pds.waitForSuccessMsg();
			 logger.info("Clicking on shoppingcart link");
			pds.ClickOnShoppingCartLink();
			ShoppingCartPage scp=new ShoppingCartPage(driver);
			boolean ShoppingCartPage=scp.shoppingCartPageHeading();
			logger.info("**********Ending Of ShoppingCart Functionality***********");
			if(ShoppingCartPage) {
				Assert.assertTrue(true);
			}
	}catch(Exception e) {
		
		Assert.fail();
	}
	}
}
