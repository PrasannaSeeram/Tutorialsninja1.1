package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC_004_SearchFunctionality extends BaseClass{
	@Test(groups="Sanity")
	 public void testSearch() {
		try {
		logger.info("starting of the test");
		HomePage hp=new HomePage(driver);
		logger.info("searching for product");
		hp.searchForProduct(properties.getProperty("product"));
		hp.clickOnSearchIcon();
		SearchPage sp=new SearchPage(driver);
		logger.info("validating the product is displayed or not");
		boolean visibleproducts = sp.visibleProduct();
		boolean searchpage = sp.searchPageheading();
		if(visibleproducts) {
			if(searchpage) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}else {
			System.out.println("no matching product");
			if(searchpage) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		logger.info("Finishing the test");
		}catch(Exception e) {
			logger.error("test got failed");
			Assert.fail();
		}
	}
	

}
