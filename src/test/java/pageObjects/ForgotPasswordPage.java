package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BaseClass  {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[normalize-space()='Forgot Your Password?']")
	WebElement Title;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_cont; 
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement Success_msg;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement Fail_msg;
	
	public boolean title() {
		return Title.isDisplayed();
	}
	public boolean email_display() {
		return email.isDisplayed();
	}
	public void email(String Email) {
		email.sendKeys(Email);
	}
	public void Cont_btn() {
		btn_cont.click();
	}
	public boolean success_msg() {
		return Success_msg.isDisplayed();
	}
	public boolean fail_msg() {
		return Fail_msg.isDisplayed();
	}
	public String email_placeholder() {
		return email.getAttribute("placeholder");
	}
	
	
	
}
