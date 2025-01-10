package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDisplayPage extends BasePage {
	
	public ProductDisplayPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//button[@id='button-cart']") WebElement btn_addtocart;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement SuccessMsg;
	@FindBy(xpath="//a[normalize-space()='shopping cart']") WebElement lnk_shoppingCart;
	
	public void clickOnAddToCartButton() {
	 btn_addtocart.click();
	}
	
	public boolean Check_SuccessMsg() {
	
		 return (SuccessMsg.isDisplayed());
       }
	public void ClickOnShoppingCartLink() {
		lnk_shoppingCart.click();
	}
	public void waitForSuccessMsg() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
	}
}
