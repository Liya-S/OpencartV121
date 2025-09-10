package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btn_cont;
	
	@FindBy(id="input-email")
	WebElement login_email;
	
	@FindBy(id="input-password")
	WebElement login_pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	
	@FindBy(xpath="//a[normalize-space()='login page']")
	WebElement login_link;
	
	@FindBy(xpath="//h2[normalize-space()='Returning Customer']")
	WebElement Login_title;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalidLogin;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement forgotPwd;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertLoginLater;
	
	
	
	public void acc_reg_cont() {            //continue to register button on login page
		btn_cont.click();
	}
	public void login_mail(String l_email) {           //email to login
		login_email.sendKeys(l_email);
	}
	public void login_pwd(String l_pwd) {            //password to login
		login_pwd.sendKeys(l_pwd);
	}
	public void login_btn() {                        //login button after giving email and password
		btn_login.click();
	}
	public void login_LINK() {            			//click login link
		login_link.click();
	}
	public boolean Login_title() {                        //Login page title
		return Login_title.isDisplayed();
	}
	public  boolean login_invalid() {						//invalid login warning message
		return invalidLogin.isDisplayed();
	}
	public  String pwd_type() {
	 	return login_pwd.getAttribute("type");
	}
	public  boolean forgot_PwdDisplay() {
		return forgotPwd.isDisplayed();
	}
	public  void forgot_PwdClick() {
		forgotPwd.click();
	} 
	public String placeholderEmail() {
		return login_email.getAttribute("placeholder");
	}
	public String placeholderPwd() {
		return login_pwd.getAttribute("placeholder");
	}
	
	
	public boolean loginLaterAlert() {
	return alertLoginLater.isDisplayed();
	}
	
	public String loginLaterMsgtxt() {
	return alertLoginLater.getText();
	}
}
