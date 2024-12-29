package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	
	}

	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement input_telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_passwordConfirm;
	@FindBy(xpath="//input[@name='agree']") WebElement checkbox_privacypolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmation;
	
	
	public void setFirstname(String firstname) {
		
		txt_firstname.sendKeys(firstname);
	}
     public void setLastname(String lastname) {
    	
    	 txt_lastname.sendKeys(lastname);
	}
     public void setEmail(String email) {
    	 
    	 txt_email.sendKeys(email);
   }
     public void setTelephone(String telephone) {
	
    	 input_telephone.sendKeys(telephone);
  }
   public void setPassword(String pwd) {
	
	   txt_password.sendKeys(pwd);
   }
    public void setPasswordConfirm(String pwdCfn) {
	
    	txt_passwordConfirm.sendKeys(pwdCfn);
  }
   public void checkPrivacypolicy() {
	
	   checkbox_privacypolicy.click();
   }
   public void clickContinue() {
	
	   btn_continue.click();
  }
   public boolean getConfirmationMsg() {
	 
	   return confirmation.isDisplayed();
	  
   }

}

