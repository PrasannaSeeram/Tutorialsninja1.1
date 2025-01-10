package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.ProductDisplayPage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC_005_AddToCartFunctionality extends BaseClass{


	 @Test(groups={"Sanity","Master"})
		public void testAddToCart() {
		 try {
			 logger.info("**********Starting Of Addtocart Functionality***********");
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
		     boolean productaddedtocart = pds.Check_SuccessMsg();
		     System.out.println(productaddedtocart);
		     logger.info("Checking product is added to the cart");
				if(productaddedtocart) {
					 logger.info("*******Ending of Addtocart Functionality*********");
				Assert.assertEquals(productaddedtocart, true);
				}else {
				   Assert.fail();
				}
		
		}catch(Exception e) {
			logger.info("testcase got failed");
		}
		 }
			
		}

