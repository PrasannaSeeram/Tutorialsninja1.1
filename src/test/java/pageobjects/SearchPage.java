package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//h2[contains(text(),'Products meeting')]")  WebElement ProductSearchPageHeading;
@FindBy(xpath="//h1[contains(text(),'hp')]")   WebElement searchPageHeading;
@FindBy(xpath="//input[contains(@value,'hp')][@id='input-search']") WebElement searchCriteria;
@FindBy(xpath="//a//img")  WebElement productResults;


public boolean visibleProduct() {

	boolean confirm = productResults.isDisplayed();
	
	return confirm;
	
}
public boolean searchPageheading() {
	boolean confirm=searchPageHeading.isDisplayed();
	return confirm;
}
	
public void productResults() {
	productResults.click();
}
	
	
	
	
	
}
