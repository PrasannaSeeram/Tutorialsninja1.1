package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnk_MyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnk_register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement  lnk_login; //login link web element
	@FindBy(xpath="//input[@placeholder='Search']")  WebElement txt_search; //search input field element
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement searchicon;//search icon for searching product
	public void clickMyAccount() {
		lnk_MyAccount.click();
	}
	
	public void clickRegister() {
		lnk_register.click();
	}
	
	public void clickLogin() {
		lnk_login.click();
	}
	public void searchForProduct(String productname) {
		txt_search.sendKeys(productname);
	}
	public void clickOnSearchIcon() {
		searchicon.click();
	}
}
