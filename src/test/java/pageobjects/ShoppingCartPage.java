package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
 @FindBy(xpath="//a[contains(text(),'Shopping Cart')]") WebElement shoppingCartPageHeading;
 
 public boolean shoppingCartPageHeading() {
	 return (shoppingCartPageHeading.isDisplayed());
 }
}
