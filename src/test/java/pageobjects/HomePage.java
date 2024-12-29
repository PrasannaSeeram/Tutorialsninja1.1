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
	public void clickMyAccount() {
		lnk_MyAccount.click();
	}
	
	public void clickRegister() {
		lnk_register.click();
	}
	
	public void clickLogin() {
		lnk_login.click();
	}
}
