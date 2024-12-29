package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgheading;  //MyAccount page Heading
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnk_logout;

	public boolean isMyAccountExists() {
		
		try {
		return (msgheading.isDisplayed());
		}catch(Exception e) {
			
			return false;
		}
	}
	
	public void clickLogout() {
		lnk_logout.click();
	}
}
